package pe.upc.pawfectcarebackend.appointmentmanagement.interfaces.rest.resources;

import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.valueobjects.AppointmentStatus;

import java.time.LocalDateTime;

public record CreateAppointmentResource(String appointmentName,
                                        LocalDateTime registrationDate,
                                        LocalDateTime endDate,
                                        boolean isMedical,
                                        AppointmentStatus status,
                                        Long petId) {
}
