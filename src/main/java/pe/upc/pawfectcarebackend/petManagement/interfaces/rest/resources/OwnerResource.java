package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources;

public record OwnerResource(
        Long id,
        String fullName,
        String phoneNumber,
        String email,
        String address) {
}
