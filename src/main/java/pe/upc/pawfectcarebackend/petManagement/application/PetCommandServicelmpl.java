package pe.upc.pawfectcarebackend.petManagement.application;

import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;
import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.CreatePetCommand;
import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.DeletePetCommand;
import pe.upc.pawfectcarebackend.petManagement.domain.model.commands.UpdatePetCommand;
import pe.upc.pawfectcarebackend.petManagement.domain.services.PetCommandService;
import pe.upc.pawfectcarebackend.petManagement.infrastructure.persistence.jpa.repositories.OwnerRepository;
import pe.upc.pawfectcarebackend.petManagement.infrastructure.persistence.jpa.repositories.PetRepository;

import java.util.Optional;
@Service
public class PetCommandServicelmpl implements PetCommandService {
    private final PetRepository petRepository;
    private  final OwnerRepository ownerRepository;
    public PetCommandServicelmpl(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }


    @Override
    public Long handle(CreatePetCommand command) {
        var pet = new Pet(command);
        try {
            if (!ownerRepository.existsById(command.ownerId())) throw new IllegalArgumentException("ownerId does not exist");
            var owner = ownerRepository.findById(command.ownerId());
            var ownerToAdd = owner.get();
            pet.addOwnerToPet(ownerToAdd);
            petRepository.save(pet);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving pet: " + e.getMessage());
        }
        return pet.getId();
    }


    @Override
    public Optional<Pet> handle(UpdatePetCommand command) {
        if (!petRepository.existsById(command.id())) throw new IllegalArgumentException("petId does not exist");
        var result = petRepository.findById(command.id());
        var petToUpdate = result.get();
        if (!ownerRepository.existsById(command.ownerId())) throw new IllegalArgumentException("ownerId does not exist");
        var owner = ownerRepository.findById(command.ownerId());
        var ownerToUpdate = owner.get();
        try {

            var updatedPet = petRepository.save(petToUpdate.updateInformation(command.petName(),command.birthDate(),command.registrationDate(),command.animalBreed(),command.petGender(),ownerToUpdate));
            return Optional.of(updatedPet);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating pet: " + e.getMessage());
        }
    }



    @Override
    public void handle(DeletePetCommand command) {
        if (!petRepository.existsById(command.petId())) {
            throw new IllegalArgumentException("Pe does not exist");
        }
        try {
            petRepository.deleteById(command.petId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting pet: " + e.getMessage());
        }

    }
}
