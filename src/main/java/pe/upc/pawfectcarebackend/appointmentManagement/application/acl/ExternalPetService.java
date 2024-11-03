package pe.upc.pawfectcarebackend.appointmentManagement.application.acl;

import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;
import pe.upc.pawfectcarebackend.petManagement.interfaces.acl.PetContextFacade;

import java.util.Optional;

@Service
public class ExternalPetService {
    private final PetContextFacade petContextFacade;

    public ExternalPetService(PetContextFacade petContextFacade) {
        this.petContextFacade = petContextFacade;
    }
    public Optional<Pet> fetchPetById(Long petId) {
        var pet = petContextFacade.fetchPetById(petId);
        return pet;
    }

}
