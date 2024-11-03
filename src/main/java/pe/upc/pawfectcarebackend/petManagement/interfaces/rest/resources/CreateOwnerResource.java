package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources;

public record CreateOwnerResource(
        String fullName,
        String phoneNumber,
        String email,
        String address) {
}
