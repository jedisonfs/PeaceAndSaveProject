package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Dependency;
import co.edu.sena.mapping.domain.ResponsibleDependency;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ResponsibleDependencyRepository extends CrudRepository<ResponsibleDependency,Integer> {

    List saveAll(Iterable Responsibledependency);

    ResponsibleDependency findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE ResponsibleDependency rd  SET rd.dependencyId = ?1 WHERE rd.id = ?2")
    int updateDependency(Dependency dependency, int id);

    void deleteById(int id);
}
