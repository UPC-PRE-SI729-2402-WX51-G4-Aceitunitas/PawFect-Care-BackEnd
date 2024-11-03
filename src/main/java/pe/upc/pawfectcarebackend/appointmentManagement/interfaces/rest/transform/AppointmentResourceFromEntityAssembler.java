package pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.transform;


import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.aggregates.Appointment;
import pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.resources.AppointmentResource;

public class AppointmentResourceFromEntityAssembler {

    public static AppointmentResource toResourceFromEntity(Appointment entity) {
        return new AppointmentResource(entity.getId(), entity.getAppointmentName(),entity.getRegistrationDate(),entity.getEndDate(),entity.isMedical(),entity.getStatus(),entity.getPet().getId());
    }
}
