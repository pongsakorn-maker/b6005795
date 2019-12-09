package se.g21.backend.employeesystem.repository;

import se.g21.backend.employeesystem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long id);
}