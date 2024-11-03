package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.CreateOwnerCommand;
import pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources.CreateOwnerResource;

public class CreateOwnerCommandFromResourceAssembler {
    public static CreateOwnerCommand toCommandFromResource(CreateOwnerResource resource) {
        return new CreateOwnerCommand(
                resource.fullName(),
                resource.phoneNumber(),
                resource.email(),
                resource.address());
    }
}

