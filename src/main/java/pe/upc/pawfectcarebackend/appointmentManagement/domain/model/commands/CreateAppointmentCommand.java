package pe.upc.pawfectcarebackend.appointmentManagement.domain.model.commands;

import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.valueobjects.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateAppointmentCommand(
      String appointmentName,
      LocalDateTime registrationDate,
      LocalDateTime endDate,
      boolean isMedical,
      AppointmentStatus status,
      Long petId ) {
}
