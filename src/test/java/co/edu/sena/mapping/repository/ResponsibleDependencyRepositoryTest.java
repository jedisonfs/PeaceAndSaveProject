package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.Customer;
//import co.edu.sena.mapping.domain.Dependency;
//import co.edu.sena.mapping.domain.ResponsibleDependency;
//import co.edu.sena.mapping.domain.enums.Condition;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ResponsibleDependencyRepositoryTest {
//
//    @Autowired
//    ResponsibleDependencyRepository responsibleDependencyRepository;
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Autowired
//    DependencyRepository dependencyRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        Customer customer = customerRepository.findByDocumentNumber("101784896");
//        Dependency dependency = dependencyRepository.findByDependencyName("GESTIÓN DEL TIC");
//
//        ResponsibleDependency responsibleDependency = new ResponsibleDependency();
//        responsibleDependency.setResponsibleState(Condition.ACTIVO);
//        responsibleDependency.setCustomer(customer);
//        responsibleDependency.setDependency(dependency);
//        responsibleDependencyRepository.save(responsibleDependency);
//
//        ResponsibleDependency responsibleDependency1 = responsibleDependency;
//        assertEquals(responsibleDependency.getId(), responsibleDependency1.getId());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        Customer customer = customerRepository.findByDocumentNumber("121045789");
//        Dependency dependency = dependencyRepository.findByDependencyName("ADMINISTRACIÓN DE DOCUMENTOS");
//
//        ResponsibleDependency responsibleDependency = new ResponsibleDependency();
//        responsibleDependency.setResponsibleState(Condition.ACTIVO);
//        responsibleDependency.setCustomer(customer);
//        responsibleDependency.setDependency(dependency);
//
//        Customer customer2 = customerRepository.findByDocumentNumber("121078486");
//        Dependency dependency2 = dependencyRepository.findByDependencyName("ENTREGA CARNÉ / SECRETARÍA GENERAL");
//
//        ResponsibleDependency responsibleDependency2 = new ResponsibleDependency();
//        responsibleDependency2.setResponsibleState(Condition.ACTIVO);
//        responsibleDependency2.setCustomer(customer2);
//        responsibleDependency2.setDependency(dependency2);
//
//        List responciblesDependencies = new ArrayList();
//        responciblesDependencies.add(responsibleDependency);
//        responciblesDependencies.add(responsibleDependency2);
//
//        responsibleDependencyRepository.saveAll(responciblesDependencies);
//        assertEquals(responciblesDependencies, responciblesDependencies);
//    }
//
//    @Test
//    @Order(3)
//    void findById() {
//        ResponsibleDependency responsibleDependency = responsibleDependencyRepository.findById(117);
//        assertNotNull(responsibleDependency);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List responsibleDependecy = (List) responsibleDependencyRepository.findAll();
//        assertNotNull(responsibleDependecy);
//    }
//
//    @Test
//    @Order(5)
//    void updateDependency() {
//        Dependency dependency = dependencyRepository.findByDependencyName("ADMINISTRACIÓN DE DOCUMENTOS");
//
//        int responsibleDependency = responsibleDependencyRepository.updateDependency(dependency, 119);
//        assertEquals(responsibleDependency, 1);
//    }
//
//    @Test
//    @Order(6)
//    void existsById() {
//        boolean responsibleDependency = responsibleDependencyRepository.existsById(119);
//        assertTrue(responsibleDependency);
//    }
//
//    @Test
//    @Order(7)
//    void deleteById() {
//        responsibleDependencyRepository.deleteById(117);
//        assertEquals(responsibleDependencyRepository.count(), 2);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll() {
//        List list = (List) responsibleDependencyRepository.findAll();
//        responsibleDependencyRepository.deleteAll(list);
//        assertTrue(responsibleDependencyRepository.count() == 0);
//    }
}