package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Contract;
import co.edu.sena.mapping.domain.Regional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface RegionalRepository extends CrudRepository<Regional, Integer> {

    Regional save(Regional regional);

    @Transactional
    @Modifying
    @Query("UPDATE Regional r SET r.regionalName = ?1 WHERE r.regionalCode = ?2")
    int updateContract(String regionalName, int regionalNumber);

    Regional findByRegionalCode(int regionalCode);

    boolean existsById(int id);

    @Transactional
    @Modifying
    @Query("delete from Regional r where r.regionalCode = ?1")
    void deleteByRegionalCode(int regionalCode);
}
