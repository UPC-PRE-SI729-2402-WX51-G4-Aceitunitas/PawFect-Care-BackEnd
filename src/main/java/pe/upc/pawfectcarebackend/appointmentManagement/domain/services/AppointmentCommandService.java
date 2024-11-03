package pe.upc.pawfectcarebackend.appointmentManagement.domain.services;

import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.aggregates.Appointment;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.commands.CreateAppointmentCommand;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.commands.UpdateAppointmentCommand;


import java.util.Optional;

public interface AppointmentCommandService {
    Optional<Appointment> handle(UpdateAppointmentCommand command);
    Long handle(CreateAppointmentCommand command);
}
