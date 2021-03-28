package pl.sleipnjs.ankietaobywatelska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sleipnjs.ankietaobywatelska.model.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
  @Query(value = "SELECT * FROM form AS f ORDER BY f.response_counter DESC LIMIT ?1", nativeQuery = true)
  Iterable<Form> fintMostLiked(int limit);

}
