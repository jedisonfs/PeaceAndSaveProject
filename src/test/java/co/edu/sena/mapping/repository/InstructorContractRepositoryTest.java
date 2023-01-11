package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.Contract;
//import co.edu.sena.mapping.domain.Instructor;
//import co.edu.sena.mapping.domain.InstructorContract;
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
class InstructorContractRepositoryTest {

//    @Autowired
//    InstructorContractRepository instructorContractRepository;
//
//    @Autowired
//    ContractRepository contractRepository;
//
//    @Autowired
//    InstructorRepository instructorRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        Contract contract = contractRepository.findByContractNumber(159753456);
//        Instructor instructor = instructorRepository.findById(31);
//
//        InstructorContract instructorContract = new InstructorContract();
//        instructorContract.setContractState(Condition.ACTIVO);
//        instructorContract.setContract(contract);
//        instructorContract.setInstructor(instructor);
//        instructorContractRepository.save(instructorContract);
//        InstructorContract instructorContract2 = instructorContract;
//        assertEquals(instructorContract.getId(), instructorContract2.getId());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        Contract contract = contractRepository.findByContractNumber(987654321);
//        Instructor instructor = instructorRepository.findById(30);
//
//        InstructorContract instructorContract = new InstructorContract();
//        instructorContract.setContractState(Condition.ACTIVO);
//        instructorContract.setContract(contract);
//        instructorContract.setInstructor(instructor);
//
//        Contract contract2 = contractRepository.findByContractNumber(45689123);
//        Instructor instructor2 = instructorRepository.findById(32);
//
//        InstructorContract instructorContract2 = new InstructorContract();
//        instructorContract2.setContractState(Condition.ACTIVO);
//        instructorContract2.setContract(contract2);
//        instructorContract2.setInstructor(instructor2);
//
//        List list = new ArrayList();
//        list.add(instructor);
//        list.add(instructor2);
//
//        instructorContractRepository.saveAll(list);
//        assertEquals(list, list);
//    }
//
//    @Test
//    @Order(3)
//    void findById() {
//        InstructorContract instructorContract = instructorContractRepository.findById(60);
//        assertNotNull(instructorContract);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List instructorContract = (List) instructorContractRepository.findAll();
//        assertNotNull(instructorContract);
//    }
//
//    @Test
//    @Order(5)
//    void existsById() {
//        boolean instructorContract = instructorContractRepository.existsById(60);
//        assertTrue(instructorContract);
//    }
//
//    @Test
//    @Order(6)
//    void updateInstructorContract() {
//        int instructorContract = instructorContractRepository.updateInstructorContract(Condition.INACTIVO, 60);
//        assertEquals(instructorContract, 1);
//    }
//
//    @Test
//    @Order(7)
//    void deleteById() {
//        instructorContractRepository.deleteById(60);
//        assertEquals(instructorContractRepository.count(), 1);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll() {
//        List instrucotrContract = (List) instructorContractRepository.findAll();
//        instructorContractRepository.deleteAll();
//        assertTrue(instructorContractRepository.count() == 0);
//    }
}