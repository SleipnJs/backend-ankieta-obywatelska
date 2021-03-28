package pl.sleipnjs.ankietaobywatelska.repository;

import pl.sleipnjs.ankietaobywatelska.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
	List<User> findByUsernameContaining(String username);
}
