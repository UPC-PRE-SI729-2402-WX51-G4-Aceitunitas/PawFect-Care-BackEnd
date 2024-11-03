package pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.commands;

import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.valueobjects.AppointmentStatus;

import java.time.LocalDateTime;

public record CreateAppointmentCommand(
      String appointmentName,
      LocalDateTime registrationDate,
      LocalDateTime endDate,
      boolean isMedical,
      AppointmentStatus status,
      Long petId ) {
}
