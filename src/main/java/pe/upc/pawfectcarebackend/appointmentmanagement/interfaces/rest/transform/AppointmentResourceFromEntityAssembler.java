package pe.upc.pawfectcarebackend.appointmentmanagement.interfaces.rest.transform;


import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.aggregates.Appointment;
import pe.upc.pawfectcarebackend.appointmentmanagement.interfaces.rest.resources.AppointmentResource;

public class AppointmentResourceFromEntityAssembler {

    public static AppointmentResource toResourceFromEntity(Appointment entity) {
        return new AppointmentResource(entity.getId(), entity.getAppointmentName(),entity.getRegistrationDate(),entity.getEndDate(),entity.isMedical(),entity.getStatus(),entity.getPet().getId());
    }
}
