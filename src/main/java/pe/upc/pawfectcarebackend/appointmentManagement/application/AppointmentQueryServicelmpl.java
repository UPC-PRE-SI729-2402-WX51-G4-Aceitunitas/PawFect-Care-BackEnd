package pe.upc.pawfectcarebackend.appointmentManagement.application;

import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.appointmentManagement.application.acl.ExternalPetService;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.aggregates.Appointment;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.queries.GetAllAppointmentsQuery;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.queries.GetAppointmentByIdQuery;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.services.AppointmentQueryService;
import pe.upc.pawfectcarebackend.appointmentManagement.infrastructure.persistence.jpa.repositories.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentQueryServicelmpl implements AppointmentQueryService{
    private final AppointmentRepository appointmentRepository;
    public AppointmentQueryServicelmpl(AppointmentRepository appointmentRepository, ExternalPetService externalPetService) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> handle(GetAppointmentByIdQuery query) {
        return appointmentRepository.findById(query.appointmentId());
    }

    @Override
    public List<Appointment> handle(GetAllAppointmentsQuery query) {
        return appointmentRepository.findAll();
    }

}
