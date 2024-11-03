package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources;

import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;

import java.util.List;

public record OwnerResource(
        Long id,
        String fullName,
        String phoneNumber,
        String email,
        String address,
        List<Pet> pets) {
}
