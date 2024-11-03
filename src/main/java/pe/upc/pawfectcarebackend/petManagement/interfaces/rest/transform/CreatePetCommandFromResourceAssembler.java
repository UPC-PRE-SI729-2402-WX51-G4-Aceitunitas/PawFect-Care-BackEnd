package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.CreatePetCommand;
import pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources.CreatePetResource;

public class CreatePetCommandFromResourceAssembler {
    public static CreatePetCommand toCommandFromResource(CreatePetResource resource) {
        return new CreatePetCommand(resource.petName(),resource.birthDate(),resource.registrationDate(), resource.animalBreed(), resource.petGender(),resource.ownerId());
    }
}
