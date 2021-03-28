package pl.sleipnjs.ankietaobywatelska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sleipnjs.ankietaobywatelska.model.FormStage;

@Repository
public interface FormRepository extends JpaRepository<FormStage, Long> {
    @Query("SELECT st FROM FormStage st WHERE st.form.id = ?1 AND st.stageNumber = ?2")
    FormStage findByFormId(long formId, int stageId);
}
