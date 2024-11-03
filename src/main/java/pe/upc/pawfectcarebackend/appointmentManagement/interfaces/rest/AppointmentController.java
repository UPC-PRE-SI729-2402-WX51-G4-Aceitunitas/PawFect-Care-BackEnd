package pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.queries.GetAllAppointmentsQuery;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.queries.GetAppointmentByIdQuery;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.services.AppointmentCommandService;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.services.AppointmentQueryService;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.resources.AppointmentResource;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.resources.CreateAppointmentResource;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.resources.UpdateAppointmentResource;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.transform.AppointmentResourceFromEntityAssembler;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.transform.CreateAppointmentCommandFromResourceAssembler;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.transform.UpdateAppointmentCommandFromResourceAssembler;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/appointments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Appointment", description = "Appointment Management Endpoints")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
    private final AppointmentCommandService appointmentCommandService;
    private final AppointmentQueryService appointmentQueryService;
    public AppointmentController( AppointmentQueryService appointmentQueryService,AppointmentCommandService appointmentCommandService) {
        this.appointmentCommandService = appointmentCommandService;
        this.appointmentQueryService = appointmentQueryService;
    }
    @PostMapping
    public ResponseEntity<AppointmentResource> createAppointment(@RequestBody CreateAppointmentResource createAppointmentResource) {
        var createAppointmentCommand = CreateAppointmentCommandFromResourceAssembler.toCommandFromResource(createAppointmentResource);
        var appointmentId = appointmentCommandService.handle(createAppointmentCommand);
        if (appointmentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getAppointmentById = new GetAppointmentByIdQuery(appointmentId);
        var appointment = appointmentQueryService.handle(getAppointmentById);
        if (appointment.isEmpty()) return ResponseEntity.badRequest().build();
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(appointment.get());
        return new ResponseEntity<>(appointmentResource, HttpStatus.CREATED);
    }


    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResource> getAppointmentById(@PathVariable Long appointmentId) {
        var getAppointmentByIdQuery = new GetAppointmentByIdQuery(appointmentId);
        var appointment = appointmentQueryService.handle(getAppointmentByIdQuery);
        if (appointment.isEmpty()) return ResponseEntity.badRequest().build();
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(appointment.get());
        return ResponseEntity.ok(appointmentResource);
    }


    @GetMapping
    public ResponseEntity<List<AppointmentResource>> getAllAppointments() {
        var getAllAppointmentsQuery = new GetAllAppointmentsQuery();
        var appointments = appointmentQueryService.handle(getAllAppointmentsQuery);
        var appointmentResources = appointments.stream().map(AppointmentResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(appointmentResources);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResource> updateAppointment(@PathVariable Long appointmentId, @RequestBody UpdateAppointmentResource updateAppointmentResource) {
        var updateAppointmentCommand = UpdateAppointmentCommandFromResourceAssembler.toCommandFromResource(appointmentId, updateAppointmentResource);
        var updatedAppointment = appointmentCommandService.handle(updateAppointmentCommand);
        if (updatedAppointment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(updatedAppointment.get());
        return ResponseEntity.ok(appointmentResource);
    }





}