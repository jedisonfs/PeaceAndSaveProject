package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.PeaceAndSave;
import co.edu.sena.mapping.domain.Request;
import co.edu.sena.mapping.domain.ResponsibleDependency;
import co.edu.sena.mapping.domain.enums.Condition;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PeaceAndSaveRepositoryTest {

    @Autowired
    PeaceAndSaveRepository peaceAndSaveRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ResponsibleDependencyRepository responsibleDependencyRepository;

    @Test
    @Order(1)
    void save() {
        ResponsibleDependency responsibleId = responsibleDependencyRepository.findById(120);
        Request request = requestRepository.findById(84);

        PeaceAndSave peaceAndSave = new PeaceAndSave();
        peaceAndSave.setStatePeaceAndSave(Condition.ACTIVO);
        peaceAndSave.setRequest(request);
        peaceAndSave.setResponsibleDependency(responsibleId);
        peaceAndSaveRepository.save(peaceAndSave);

        PeaceAndSave peaceAndSave1 = peaceAndSave;
        assertEquals(peaceAndSave.getId(),peaceAndSave1.getId());
    }

    @Test
    @Order(2)
    void saveAll() {
        ResponsibleDependency responsibleId = responsibleDependencyRepository.findById(121);
        Request request = requestRepository.findById(87);

        PeaceAndSave peaceAndSave = new PeaceAndSave();
        peaceAndSave.setStatePeaceAndSave(Condition.ACTIVO);
        peaceAndSave.setRequest(request);
        peaceAndSave.setResponsibleDependency(responsibleId);

        ResponsibleDependency responsibleId2 = responsibleDependencyRepository.findById(122);
        Request request2 = requestRepository.findById(88);

        PeaceAndSave peaceAndSave2 = new PeaceAndSave();
        peaceAndSave2.setStatePeaceAndSave(Condition.ACTIVO);
        peaceAndSave2.setRequest(request2);
        peaceAndSave2.setResponsibleDependency(responsibleId2);

        List list = new ArrayList();
        list.add(peaceAndSave);
        list.add(peaceAndSave2);

        peaceAndSaveRepository.saveAll(list);
        assertEquals(list,list);
    }

    @Test
    @Order(3)
    void findById() {
        PeaceAndSave peaceAndSave = peaceAndSaveRepository.findById(127);
        assertNotNull(peaceAndSave);
    }

    @Test
    @Order(4)
    void findAll() {
        List peaceAndSave = (List) peaceAndSaveRepository.findAll();
        assertNotNull(peaceAndSave);
    }

    @Test
    @Order(6)
    void updateStatePeaceAndSave() {
        int peaceAndSave = peaceAndSaveRepository.updateStatePeaceAndSave(Condition.INACTIVO,127);
        assertEquals(peaceAndSave,1);
    }

    @Test
    @Order(6)
    void existsById() {
        boolean peaceAndSave = peaceAndSaveRepository.existsById(127);
        assertTrue(peaceAndSave);
    }

    @Test
    @Order(7)
    void deleteById() {
        peaceAndSaveRepository.deleteById(126);
        assertEquals(peaceAndSaveRepository.count(), 2);
    }

    @Test
    @Order(8)
    void deleteAll() {
        List peaceAndSave = (List) peaceAndSaveRepository.findAll();
        peaceAndSaveRepository.deleteAll(peaceAndSave);
        assertTrue(peaceAndSaveRepository.count() == 0);
    }
}