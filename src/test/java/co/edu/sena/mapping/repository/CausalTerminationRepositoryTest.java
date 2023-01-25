package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.CausalTermination;
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
class CausalTerminationRepositoryTest {

//    @Autowired
//    CausalTerminationRepository causalTerminationRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        CausalTermination causalTermination = new CausalTermination();
//        causalTermination.setCausalName("Perdida de material prestado");
//        causalTermination.setCausalState(Condition.ACTIVO);
//        causalTerminationRepository.save(causalTermination);
//        CausalTermination causalTermination1 = causalTerminationRepository.findByCausalName("Perdida de material prestado");
//        assertEquals(causalTermination.getCausalName(), causalTermination1.getCausalName());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        CausalTermination causalTermination = new CausalTermination();
//        causalTermination.setCausalName("Deuda en cafeteria");
//        causalTermination.setCausalState(Condition.ACTIVO);
//
//        CausalTermination causalTermination1 = new CausalTermination();
//        causalTermination1.setCausalName("Falta de reglamento");
//        causalTermination1.setCausalState(Condition.ACTIVO);
//
//        List causalTermminations = new ArrayList();
//        causalTermminations.add(causalTermination);
//        causalTermminations.add(causalTermination1);
//
//        causalTerminationRepository.saveAll(causalTermminations);
//        assertEquals(causalTermminations,causalTermminations);
//    }
//
//    @Test
//    @Order(3)
//    void findByCausalName() {
//        CausalTermination causalTermination = causalTerminationRepository.findByCausalName("Perdida de material prestado");
//        assertNotNull(causalTermination);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List causalTermination = (List) causalTerminationRepository.findAll();
//        assertNotNull(causalTermination);
//    }
//    @Test
//    @Order(5)
//    void updateCuasalTermination() {
//        int causalTermination = causalTerminationRepository.updateCuasalTermination("No cumplir con el horario",67);
//        assertEquals(causalTermination,1);
//    }
//
//    @Test
//    @Order(6)
//    void existsById() {
//        boolean causalTrmination = causalTerminationRepository.existsById(67);
//        assertTrue(causalTrmination);
//    }
//
//    @Test
//    @Order(7)
//    void deleteById() {
//        causalTerminationRepository.deleteById(67);
//        assertEquals(causalTerminationRepository.count(),2);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll() {
//        List causlaterminations = (List) causalTerminationRepository.findAll();
//        causalTerminationRepository.deleteAll(causlaterminations);
//        assertTrue(causalTerminationRepository.count() == 0);
//    }
}