package pe.upc.pawfectcarebackend.appointmentmanagement.domain.services;

import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.aggregates.Appointment;
import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.queries.GetAllAppointmentsQuery;
import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.queries.GetAppointmentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    Optional<Appointment> handle(GetAppointmentByIdQuery query);
    List<Appointment> handle(GetAllAppointmentsQuery query);
}
