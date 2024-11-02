package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources;

public record UpdateOwnerResource(
        String fullName,
        String phoneNumber,
        String email,
        String address
) {
}
