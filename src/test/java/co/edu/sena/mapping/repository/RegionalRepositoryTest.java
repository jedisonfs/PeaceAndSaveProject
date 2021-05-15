package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.enums.Condition;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RegionalRepositoryTest {

//    @Autowired
//    RegionalRepository regionalRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        Regional regional = new Regional();
//        regional.setRegionalCode(123);
//        regional.setRegionalName("Antioquia");
//        regional.setRegionalState(Condition.ACTIVO);
//        regionalRepository.save(regional);
//        Regional regional2 = regional;
//        assertEquals(regional.getId(),regional2.getId());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        Regional regional = new Regional();
//        regional.setRegionalCode(456);
//        regional.setRegionalName("Distrito capital");
//        regional.setRegionalState(Condition.ACTIVO);
//
//        Regional regional2 = new Regional();
//        regional2.setRegionalCode(789);
//        regional2.setRegionalName("Tolima");
//        regional2.setRegionalState(Condition.ACTIVO);
//
//        List regionals = new ArrayList();
//        regionals.add(regional);
//        regionals.add(regional2);
//
//        regionalRepository.saveAll(regionals);
//        assertEquals(regionals,regionals);
//    }
//
//    @Test
//    @Order(3)
//    void findByRegionalCode() {
//        Regional regional = regionalRepository.findByRegionalCode(123);
//        assertNotNull(regional);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List regionals = (List) regionalRepository.findAll();
//        assertNotNull(regionals);
//    }
//
//    @Test
//    @Order(5)
//    void updateContract() {
//        int regional = regionalRepository.updateContract("Bogota",456);
//        assertEquals(regional,1);
//    }
//
//    @Test
//    @Order(6)
//    void existsById() {
//        boolean  regional = regionalRepository.existsById(90);
//        assertTrue(regional);
//    }
//
//    @Test
//    @Order(7)
//    void deleteByContractNumber() {
//        regionalRepository.deleteByRegionalCode(123);
//        assertEquals(regionalRepository.count(),2);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll() {
//        List regionals = (List) regionalRepository.findAll();
//        regionalRepository.deleteAll(regionals);
//        assertTrue(regionalRepository.count() == 0);
//    }
}