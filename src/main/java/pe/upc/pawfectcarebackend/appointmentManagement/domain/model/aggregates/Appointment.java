package pe.upc.pawfectcarebackend.appointmentManagement.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.commands.CreateAppointmentCommand;
import pe.upc.pawfectcarebackend.appointmentManagement.domain.model.valueobjects.AppointmentStatus;
import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;
import pe.upc.pawfectcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;


@Getter
@Entity
public class Appointment extends AuditableAbstractAggregateRoot<Appointment> {

    private String appointmentName;
    private LocalDateTime registrationDate;
    private LocalDateTime endDate;
    private boolean isMedical;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @Getter
    @ManyToOne
    @JoinColumn(name = "pet_id")
    @NotNull
    private Pet pet;

    public Appointment() {
        this.appointmentName = Strings.EMPTY;
        this.registrationDate = LocalDateTime.now();
        this.endDate = LocalDateTime.now();
        this.isMedical = false;
        this.status = AppointmentStatus.SCHEDULED;
        this.pet = new Pet();
    }

    public Appointment(CreateAppointmentCommand command, Pet pet) {
        this();
        this.appointmentName = command.appointmentName();
        this.registrationDate = command.registrationDate();
        this.endDate = command.endDate();
        this.isMedical = command.isMedical();
        this.status = AppointmentStatus.SCHEDULED;
        this.pet = pet;
    }

    public Appointment updateInformation(String appointmentName,LocalDateTime registrationDate,LocalDateTime endDate, boolean isMedical,AppointmentStatus status ) {
        this.appointmentName = appointmentName;
        this.registrationDate = registrationDate;
        this.endDate = endDate;
        this.isMedical = isMedical;
        this.status = status;
        return this;
    }

}
