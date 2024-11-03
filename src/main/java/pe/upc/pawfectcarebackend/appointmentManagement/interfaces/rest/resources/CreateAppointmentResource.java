package pe.upc.pawfectcarebackend.appointmentManagement.interfaces.rest.resources;

import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.valueobjects.AppointmentStatus;

import java.time.LocalDateTime;

public record CreateAppointmentResource(String appointmentName,
                                        LocalDateTime registrationDate,
                                        LocalDateTime endDate,
                                        boolean isMedical,
                                        AppointmentStatus status,
                                        Long petId) {
}
