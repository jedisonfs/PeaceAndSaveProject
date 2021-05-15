package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Customer;
import co.edu.sena.mapping.domain.TypeDocument;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer save(Customer customer);

    @Query("select c from Customer c where c.documentNumber = ?1 ")
    Customer findByDocumentNumber(String number);

    @Transactional
    @Modifying
    @Query("Update Customer c set c.typeDocumentId = ?1 where c.documentNumber = ?2")
    int updateCustomer(TypeDocument typeDocument, String documentNumber);

    boolean existsByDocumentNumber(String numero);

}
