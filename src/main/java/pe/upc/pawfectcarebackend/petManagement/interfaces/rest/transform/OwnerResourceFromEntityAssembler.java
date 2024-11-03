package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.transform;


import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Owner;
import pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources.OwnerResource;

public class OwnerResourceFromEntityAssembler {
    public static OwnerResource toResourceFromEntity(Owner entity) {
        return new OwnerResource(
                entity.getId(),
                entity.getFullName(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getAddress());
    }
}
