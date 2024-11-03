package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.UpdateOwnerCommand;
import pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources.UpdateOwnerResource;

public class UpdateOwnerCommandFromResourceAssembler {
    public static UpdateOwnerCommand toCommandFromResource(Long ownerId, UpdateOwnerResource resource) {
        return new UpdateOwnerCommand(ownerId, resource.fullName(),resource.phoneNumber(),resource.email(),resource.address());
    }
}
