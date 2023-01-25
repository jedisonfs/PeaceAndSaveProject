package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.Dependency;
//import co.edu.sena.mapping.domain.TrainingCenter;
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
class DependencyRepositoryTest {

//    @Autowired
//    DependencyRepository dependencyRepositoy;
//
//    @Autowired
//    TrainingCenterRepository trainingCenterRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        TrainingCenter trainingCenter = trainingCenterRepository.findByCenterCode(321);
//
//        Dependency dependency = new Dependency();
//        dependency.setDependencyName("GESTIÓN DEL TIC");
//        dependency.setDependencyState(Condition.ACTIVO);
//        dependency.setDependencyUbication("2");
//        dependency.setTrainingCenter(trainingCenter);
//
//        dependencyRepositoy.save(dependency);
//        Dependency dependency2 = dependency;
//
//        assertEquals(dependency.getId(),dependency2.getId());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        TrainingCenter trainingCenter = trainingCenterRepository.findByCenterCode(845);
//
//        Dependency dependency = new Dependency();
//        dependency.setDependencyName("ADMINISTRACIÓN DE DOCUMENTOS");
//        dependency.setDependencyState(Condition.ACTIVO);
//        dependency.setDependencyUbication("3");
//        dependency.setTrainingCenter(trainingCenter);
//
//        TrainingCenter trainingCenter2 = trainingCenterRepository.findByCenterCode(851);
//
//        Dependency dependency2 = new Dependency();
//        dependency2.setDependencyName("ENTREGA CARNÉ / SECRETARÍA GENERAL");
//        dependency2.setDependencyState(Condition.ACTIVO);
//        dependency2.setDependencyUbication("4");
//        dependency2.setTrainingCenter(trainingCenter2);
//
//        List dependencys = new ArrayList();
//        dependencys.add(dependency);
//        dependencys.add(dependency2);
//
//        dependencyRepositoy.saveAll(dependencys);
//        assertEquals(dependencys,dependencys);
//    }
//
//    @Test
//    @Order(3)
//    void findByDependencyName() {
//        Dependency dependency = dependencyRepositoy.findByDependencyName("ADMINISTRACIÓN DE DOCUMENTOS");
//        assertNotNull(dependency);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List dependencys = (List) dependencyRepositoy.findAll();
//        assertNotNull(dependencys);
//    }
//
//    @Test
//    @Order(5)
//    void updateDependencyState() {
//        int dependency = dependencyRepositoy.updateDependencyState(Condition.INACTIVO,"ADMINISTRACIÓN DE DOCUMENTOS");
//        assertEquals(dependency,1);
//    }
//
//    @Test
//    @Order(6)
//    void existsById() {
//        boolean dependency = dependencyRepositoy.existsById(106);
//        assertTrue(dependency);
//    }
//
//    @Test
//    @Order(7)
//    void deleteById() {
//        dependencyRepositoy.deleteById(106);
//        assertEquals(dependencyRepositoy.count(),2);
//    }
//
//    @Test
//    @Order(8)
//    void deleteALL() {
//        List dependencys = (List) dependencyRepositoy.findAll();
//        dependencyRepositoy.deleteAll(dependencys);
//        assertTrue(dependencyRepositoy.count() == 0);
//    }
}