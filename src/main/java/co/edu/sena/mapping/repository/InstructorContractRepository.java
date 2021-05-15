package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.InstructorContract;
import co.edu.sena.mapping.domain.enums.Condition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InstructorContractRepository extends CrudRepository<InstructorContract, Integer> {

    InstructorContract findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE InstructorContract ic SET ic.contractState = ?1 WHERE ic.id= ?2")
    int updateInstructorContract(Condition condition, int id);

    void deleteById(int id);
}
