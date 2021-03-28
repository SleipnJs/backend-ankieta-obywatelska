package pl.sleipnjs.ankietaobywatelska.repository;

import pl.sleipnjs.ankietaobywatelska.model.ERole;
import pl.sleipnjs.ankietaobywatelska.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
