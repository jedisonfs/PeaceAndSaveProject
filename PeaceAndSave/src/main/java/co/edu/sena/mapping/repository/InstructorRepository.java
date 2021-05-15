package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Customer;
import co.edu.sena.mapping.domain.Instructor;
import co.edu.sena.mapping.domain.enums.Condition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    Instructor save(Instructor instructor);


    @Query("select i from Instructor i where i.id=?1")
    Instructor findById(int id);

    Instructor findByInstructorState(Condition estado);

    @Transactional
    @Modifying
    @Query("UPDATE Instructor i SET i.instructorState=?1 WHERE i.id=?2")
    int updateInstructor(Condition condition, int id);

    boolean existsById(int id);

    void deleteById(Integer id);

    void deleteAll(Iterable instructor);

}
