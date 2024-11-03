package pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.commands.CreateAppointmentCommand;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResourceAssembler {
    public static CreateAppointmentCommand toCommandFromResource(CreateAppointmentResource resource) {
        return new CreateAppointmentCommand(resource.appointmentName(), resource.registrationDate(),resource.endDate(), resource.isMedical(), resource.status(), resource.petId());
    }
}
