package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.TrainingCenter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrainingCenterRepository extends CrudRepository<TrainingCenter,Integer> {

    List saveAll(Iterable trainingCenter);

    TrainingCenter findByCenterCode(int centerCode);

//    @Transactional
//    @Modifying
//    @Query("UPDATE TrainingCenter  tc SET tc.centerName = :center WHERE tc.centerCode= ?2")
//    int updateTrainingCenter(String center, int id);

    void deleteById(int id);
}
