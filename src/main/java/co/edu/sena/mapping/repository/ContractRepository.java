package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Contract;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ContractRepository extends CrudRepository<Contract,Integer> {

    Contract save(Contract contract);

    @Transactional
    @Modifying
    @Query("UPDATE Contract c SET c.contractYear = ?1 WHERE c.contractNumber = ?2" )
    int updateContract(Date year, int contractNumber);

    Contract findByContractNumber(int contractNumber);

    boolean existsById(int id);

    @Transactional
    @Modifying
    @Query("delete from Contract c where c.contractNumber = ?1")
    void deleteByContractNumber(int number);
}
