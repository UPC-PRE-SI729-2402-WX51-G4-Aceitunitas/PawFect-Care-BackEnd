package pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.resources;

public record UpdateOwnerResource(
        String fullName,
        String phoneNumber,
        String email,
        String address
) {
}