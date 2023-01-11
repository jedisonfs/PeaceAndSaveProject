package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.Customer;
//import co.edu.sena.mapping.domain.TypeDocument;
//import co.edu.sena.mapping.domain.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Autowired
//    TypeDocumentRepository typeDocumentRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        Customer customer = new Customer();
//        customer.setDocumentNumber("101784896");
//        customer.setFirstName("Johan");
//        customer.setFirstSurname("Sanabria");
//        customer.setTypeDocument(typeDocumentRepository.findById(3));
//        customer.setUser(userRepository.findById(4));
//        customerRepository.save(customer);
//        Customer customer1 = customerRepository.findByDocumentNumber("101784896");
//        assertEquals(customer.getDocumentNumber(), customer1.getDocumentNumber());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        TypeDocument typeDocument = typeDocumentRepository.findById(7);
//        User user = userRepository.findById(1);
//        User user1 = userRepository.findById(2);
//
//
//        Customer customer = new Customer();
//        customer.setId(5);
//        customer.setDocumentNumber("121078486");
//        customer.setFirstName("Fabian");
//        customer.setFirstSurname("Sanabria");
//        customer.setTypeDocument(typeDocument);
//        customer.setUser(user);
//
//        Customer customer1 = new Customer();
//        customer1.setId(6);
//        customer1.setDocumentNumber("121045789");
//        customer1.setFirstName("Luis");
//        customer1.setFirstSurname("Feria");
//        customer1.setTypeDocument(typeDocument);
//        customer1.setUser(user1);
//
//        List<Customer> listCustomer = new ArrayList<>();
//        listCustomer.add(customer);
//        listCustomer.add(customer1);
//
//        customerRepository.saveAll(listCustomer);
//        assertEquals(listCustomer, listCustomer);
//    }
//
//    @Test
//    @Order(3)
//    void findByDocumentNumber() {
//        Customer customer = customerRepository.findByDocumentNumber("121078486");
//        assertNotNull(customer);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List customer = (List) customerRepository.findAll();
//        assertNotNull(customer);
//    }
//
//    @Test
//    @Order(5)
//    void updateCustomer() {
//        TypeDocument typeDocument = typeDocumentRepository.findById(20);
//        int customer = customerRepository.updateCustomer(typeDocument, "1007385015");
//        assertEquals(customer,1);
//    }
//
//    @Test
//    void existsByDocumentNumber() {
//        boolean customer = customerRepository.existsByDocumentNumber("1007385015");
//        assertTrue(customer);
//    }
//
//    @Test
//    void deleteByDocumentNumber() {
//        customerRepository.deleteById(26);
//        assertEquals(customerRepository.count(),2);
//    }
//
//    @Test
//    void deleteAll() {
//        List customer = (List) customerRepository.findAll();
//        customerRepository.deleteAll(customer);
//        assertTrue(customerRepository.count()==0);
//    }
}