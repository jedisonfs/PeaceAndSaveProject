package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Customer;
import co.edu.sena.mapping.domain.Instructor;
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
class InstructorRepositoryTest {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Order(1)
    void save() {
        Customer customer = customerRepository.findByDocumentNumber("121078486");

        Instructor instructor = new Instructor();
        instructor.setId(1);
        instructor.setInstructorState(Condition.ACTIVO);
        instructor.setCustomerId(customer);
        instructorRepository.save(instructor);
        Instructor instructor2 = instructor;
        assertEquals(instructor.getInstructorState(),instructor2.getInstructorState());
        assertEquals(instructor.getCustomerId(),instructor.getCustomerId());
    }

    @Test
    @Order(2)
    void saveAll() {
        Customer customer = customerRepository.findByDocumentNumber("121045789");
        Customer customer2 = customerRepository.findByDocumentNumber("101784896");

        Instructor instructor = new Instructor();
        instructor.setInstructorState(Condition.ACTIVO);
        instructor.setCustomerId(customer);

        Instructor instructor2 = new Instructor();
        instructor2.setInstructorState(Condition.ACTIVO);
        instructor2.setCustomerId(customer2);

        List instructors = new ArrayList();
        instructors.add(instructor);
        instructors.add(instructor2);
        instructorRepository.saveAll(instructors);
        assertEquals(instructors,instructors);
    }

    @Test
    @Order(3)
    void findById() {
        Instructor instructor = instructorRepository.findById(30);
        assertNotNull(instructor);
    }

    @Test
    @Order(4)
    void findAll(){
        List instructors = (List)instructorRepository.findAll();
        assertNotNull(instructors);
    }
    @Test
    @Order(5)
    void updateInstructor() {
        int instructor = instructorRepository.updateInstructor(Condition.INACTIVO,30);
        assertEquals(instructor,1);
    }

    @Test
    @Order(6)
    void existsById() {
        boolean instructor = instructorRepository.existsById(30);
        assertTrue(instructor);
    }

    @Test
    @Order(7)
    void deleteById() {
        instructorRepository.deleteById(30);
        assertTrue(instructorRepository.count()==0);
    }

    @Test
    @Order(8)
    void deleteAll() {
       List instructors = (List) instructorRepository.findAll();
       instructorRepository.deleteAll(instructors);
       assertTrue(instructorRepository.count()==0);
    }
}