package pe.upc.pawfectcarebackend.petManagement.interfaces.rest.resources;

import pe.upc.pawfectcarebackend.petManagement.domain.model.valueobjects.PetGender;

import java.time.LocalDate;

public record UpdatePetResource(String petName, LocalDate birthDate, LocalDate registrationDate,
                                String animalBreed, PetGender petGender) {

}
