package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.CausalTermination;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CausalTerminationRepository extends CrudRepository<CausalTermination,Integer> {

    CausalTermination findByCausalName(String causalName);

    CausalTermination findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE CausalTermination ct SET ct.causalName = ?1 WHERE ct.id = ?2")
    int updateCuasalTermination(String causalTerminationName,int id);

    void deleteById(int id);
}
