package pe.upc.pawfectcarebackend.petManagement.domain.model.commands;

public record CreateOwnerCommand(
        String fullName,
        String phoneNumber,
        String email,
        String address
) {

}
