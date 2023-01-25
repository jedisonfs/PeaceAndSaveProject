package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.Regional;
//import co.edu.sena.mapping.domain.TrainingCenter;
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
class TrainingCenterRepositoryTest {
//
//    @Autowired
//    TrainingCenterRepository trainingCenterRepository;
//
//    @Autowired
//    RegionalRepository regionalRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        Regional regional = regionalRepository.findByRegionalCode(123);
//
//        TrainingCenter trainingCenter = new TrainingCenter();
//        trainingCenter.setCenterCode(321);
//        trainingCenter.setCenterName("CENTRO DE DISEÑO Y METROLOGÍA");
//        trainingCenter.setCenterAnddress("Calle 15 No. 31 - 42 Torre Occidental");
//        trainingCenter.setRegional(regional);
//        trainingCenterRepository.save(trainingCenter);
//
//        TrainingCenter trainingCenter1 = trainingCenter;
//        assertEquals(trainingCenter.getId(), trainingCenter1.getId());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        Regional regional = regionalRepository.findByRegionalCode(456);
//
//        TrainingCenter trainingCenter = new TrainingCenter();
//        trainingCenter.setCenterCode(845);
//        trainingCenter.setCenterName("CENTRO DE ELECTRICIDAD, ELECTRÓNICA Y TELECOMUNICACIONES");
//        trainingCenter.setCenterAnddress("Cra 30 No. 17 B - 25 Sur");
//        trainingCenter.setRegional(regional);
//
//        Regional regional2 = regionalRepository.findByRegionalCode(789);
//
//        TrainingCenter trainingCenter1 = new TrainingCenter();
//        trainingCenter1.setCenterCode(851);
//        trainingCenter1.setCenterName("CCENTRO DE FORMACIÓN DE TALENTO HUMANO EN SALUD");
//        trainingCenter1.setCenterAnddress("Cra. 6 No. 45 - 52");
//        trainingCenter1.setRegional(regional2);
//
//        List listTraining = new ArrayList();
//        listTraining.add(trainingCenter);
//        listTraining.add(trainingCenter1);
//
//        trainingCenterRepository.saveAll(listTraining);
//        assertEquals(listTraining, listTraining);
//    }
//
//    @Test
//    @Order(3)
//    void findByCenterCode() {
//        TrainingCenter trainingCenter = trainingCenterRepository.findByCenterCode(321);
//        assertNotNull(trainingCenter);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List trainingCenter = (List) trainingCenterRepository.findAll();
//        assertNotNull(trainingCenter);
//    }
//
////    @Test
////    @Order(6)
////    void updateInstructorContract() {
////        int trainingCenter = trainingCenterRepository.updateTrainingCenter("CENTRO DE FORMACIÓN DE TALENTO HUMANO EN SALUD", 851);
////        assertEquals(trainingCenter, 1);
////    }
//
//    @Test
//    @Order(7)
//    void existsById() {
//        boolean trainingCenter = trainingCenterRepository.existsById(101);
//        assertTrue(trainingCenter);
//    }
//
//    @Test
//    @Order(8)
//    void deleteById() {
//        trainingCenterRepository.deleteById(101);
//        assertEquals(trainingCenterRepository.count(), 2);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll() {
//        List trainingCenter = (List) trainingCenterRepository.findAll();
//        trainingCenterRepository.deleteAll(trainingCenter);
//        assertTrue(trainingCenterRepository.count() == 0);
//    }
}