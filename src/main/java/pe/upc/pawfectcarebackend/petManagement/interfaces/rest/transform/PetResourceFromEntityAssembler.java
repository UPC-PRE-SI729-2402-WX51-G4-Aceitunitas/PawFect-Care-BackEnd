package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;
import pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources.PetResource;

public class PetResourceFromEntityAssembler {
    public static PetResource toResourceFromEntity(Pet entity) {
        return new PetResource(
                entity.getId(),
                entity.getPetName(),
                entity.getBirthDate(),
                entity.getRegistrationDate(),
                entity.getAnimalBreed(),
                entity.getPetGender(),
                entity.getOwner().getId());
    }
}
