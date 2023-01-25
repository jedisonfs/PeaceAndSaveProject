package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Roles findByName(String role);
}
