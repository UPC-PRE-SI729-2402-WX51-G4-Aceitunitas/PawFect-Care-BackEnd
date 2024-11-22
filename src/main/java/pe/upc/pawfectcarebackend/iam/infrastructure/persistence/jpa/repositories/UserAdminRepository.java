package pe.upc.pawfectcarebackend.iam.infrastructure.persistence.jpa.repositories;

import pe.upc.pawfectcarebackend.iam.domain.model.aggregates.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the UserAdmin entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long>
{
    /**
     * This method is responsible for finding the user by username.
     * @param username The username.
     * @return The user object.
     */
    Optional<UserAdmin> findByUsername(String username);

    /**
     * This method is responsible for checking if the user exists by username.
     * @param username The username.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByUsername(String username);

}
