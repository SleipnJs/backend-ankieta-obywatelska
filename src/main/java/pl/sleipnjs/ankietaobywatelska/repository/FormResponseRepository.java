package pl.sleipnjs.ankietaobywatelska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sleipnjs.ankietaobywatelska.model.FormResponse;

import java.util.List;

@Repository
public interface FormResponseRepository extends JpaRepository<FormResponse, Long> {
   @Query("SELECT fr FROM FormResponse fr WHERE fr.form.id = ?1")
  List<FormResponse> findByFormId(long formId);
}
