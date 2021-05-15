package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Dependency;
import co.edu.sena.mapping.domain.enums.Condition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DependencyRepository extends CrudRepository<Dependency, Integer> {

    List saveAll(Iterable dependency);

    Dependency findByDependencyName(String dependencyName);

    @Transactional
    @Modifying
    @Query("UPDATE Dependency d SET d.dependencyState = ?1 WHERE d.dependencyName = ?2")
    int updateDependencyState(Condition estado, String dapendencyName);

    void deleteById(int id);
}
