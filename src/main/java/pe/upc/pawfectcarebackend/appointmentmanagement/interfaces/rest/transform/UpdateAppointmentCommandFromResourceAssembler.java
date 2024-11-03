package pe.upc.pawfectcarebackend.appointmentmanagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.commands.UpdateAppointmentCommand;
import pe.upc.pawfectcarebackend.appointmentmanagement.interfaces.rest.resources.UpdateAppointmentResource;

public class UpdateAppointmentCommandFromResourceAssembler {
    public static UpdateAppointmentCommand toCommandFromResource(
            Long appointmentId,
            UpdateAppointmentResource resource) {
        return new UpdateAppointmentCommand(
                appointmentId,
                resource.appointmentName(),
                resource.registrationDate(),
                resource.endDate(),
                resource.isMedical(),
                resource.status());
    }
}
