package pe.upc.pawfectcarebackend.appointmentmanagement.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.pawfectcarebackend.appointmentmanagement.domain.model.aggregates.Appointment;
@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment, Long>{
}