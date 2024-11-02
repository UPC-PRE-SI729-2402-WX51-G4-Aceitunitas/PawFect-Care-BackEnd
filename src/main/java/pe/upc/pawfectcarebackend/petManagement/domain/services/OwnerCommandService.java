package pe.upc.pawfectcarebackend.petManagement.domain.services;
import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Owner;
import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.CreateOwnerCommand;
import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.UpdateOwnerCommand;
import java.util.Optional;

public interface OwnerCommandService {
    Optional<Owner> handle(UpdateOwnerCommand command);
    Long handle(CreateOwnerCommand command);

}
