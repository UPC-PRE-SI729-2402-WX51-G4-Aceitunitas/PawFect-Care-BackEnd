package pe.upc.pawfectcarebackend.petManagement.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
      boolean existsById(Long petId);
}
