package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.CausalTermination;
import co.edu.sena.mapping.domain.Request;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request,Integer> {

    Request save(Request request);

    List saveAll(Iterable requests);

    Request findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Request r SET r.causalTerminationId = ?1 WHERE r.id = ?2")
    int updateRequest(CausalTermination causalTermination,int id);

    void deleteById(int id);
}
