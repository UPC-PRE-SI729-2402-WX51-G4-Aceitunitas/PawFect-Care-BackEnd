package pe.upc.pawfectcarebackend.petManagement.domain.services;

import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;

import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.CreatePetCommand;
import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.UpdatePetCommand;

import java.util.Optional;

public interface PetCommandService {
    Optional<Pet> handle(UpdatePetCommand command);
    Long handle(CreatePetCommand command);

}
