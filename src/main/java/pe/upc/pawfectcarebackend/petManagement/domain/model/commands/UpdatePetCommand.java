package pe.upc.pawfectcarebackend.petManagement.domain.model.commands;


import pe.upc.pawfectcarebackend.petManagement.domain.model.valueobjects.PetGender;

import java.time.LocalDate;

public record UpdatePetCommand(Long id, String petName, LocalDate birthDate,LocalDate registrationDate,
                               String animalBreed, PetGender petGender) {
}