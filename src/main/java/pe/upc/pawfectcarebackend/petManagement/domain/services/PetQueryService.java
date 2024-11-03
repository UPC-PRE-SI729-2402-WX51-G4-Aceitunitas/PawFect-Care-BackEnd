package pe.upc.pawfectcarebackend.petManagement.domain.services;

import java.util.List;
import java.util.Optional;

import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;
import pe.upc.pawfectcarebackend.petManagement.domain.model.queries.GetAllPetsQuery;
import pe.upc.pawfectcarebackend.petManagement.domain.model.queries.GetPetByIdQuery;

public interface PetQueryService {
   Optional<Pet> handle(GetPetByIdQuery query);
   List<Pet> handle(GetAllPetsQuery query);
}
