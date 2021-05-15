package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.PeaceAndSave;
import co.edu.sena.mapping.domain.enums.Condition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PeaceAndSaveRepository extends CrudRepository<PeaceAndSave, Integer> {

    List saveAll(Iterable peaceAndaSave);

    PeaceAndSave findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE PeaceAndSave p SET p.statePeaceAndSave = ?1 WHERE p.id = ?2")
    int updateStatePeaceAndSave(Condition estado, int id);


}
