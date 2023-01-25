package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.CausalTermination;
//import co.edu.sena.mapping.domain.InstructorContract;
//import co.edu.sena.mapping.domain.Request;
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
class RequestRepositoryTest {
//
//    @Autowired
//    RequestRepository requestRepository;
//
//    @Autowired
//    CausalTerminationRepository causalTerminationRepository;
//
//    @Autowired
//    InstructorContractRepository instructorContractRepository;
//
//    @Test
//    @Order(1)
//    void save() {
//        CausalTermination causalTermination = causalTerminationRepository.findByCausalName("Falta de reglamento");
//        InstructorContract instructorContract = instructorContractRepository.findById(65);
//
//        Request request = new Request();
//        request.setCausalTermination(causalTermination);
//        request.setInstructorContract(instructorContract);
//        requestRepository.save(request);
//        Request request1 = request;
//        assertEquals(request.getId(),request.getId());
//    }
//
//    @Test
//    @Order(2)
//    void saveAll() {
//        CausalTermination causalTermination = causalTerminationRepository.findByCausalName("Falta de reglamento");
//        InstructorContract instructorContract = instructorContractRepository.findById(61);
//
//        Request request = new Request();
//        request.setCausalTermination(causalTermination);
//        request.setInstructorContract(instructorContract);
//
//        CausalTermination causalTermination2 = causalTerminationRepository.findByCausalName("Falta de reglamento");
//        InstructorContract instructorContract2 = instructorContractRepository.findById(60);
//
//        Request request2 = new Request();
//        request2.setCausalTermination(causalTermination2);
//        request2.setInstructorContract(instructorContract2);
//
//        List requests = new ArrayList();
//        requests.add(request);
//        requests.add(request2);
//
//        requestRepository.saveAll(requests);
//        assertEquals(request,request);
//    }
//
//    @Test
//    @Order(3)
//    void findById() {
//        Request request = requestRepository.findById(81);
//        assertNotNull(request);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List requests  = (List) requestRepository.findAll();
//        assertNotNull(requests);
//    }
//
//    @Test
//    @Order(5)
//    void updateRequest() {
//        CausalTermination causalTermination = causalTerminationRepository.findByCausalName("Deuda en cafeteria");
//        int request = requestRepository.updateRequest(causalTermination,81);
//        assertEquals(request,1);
//    }
//
//    @Test
//    @Order(6)
//    void existsId() {
//        boolean request = requestRepository.existsById(81);
//        assertTrue(request);
//    }
//
//    @Test
//    @Order(7)
//    void deleteById() {
//        requestRepository.deleteById(81);
//        assertEquals(requestRepository.count(),2);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll () {
//        List requests = (List) requestRepository.findAll();
//        requestRepository.deleteAll(requests);
//        assertTrue(requestRepository.count() == 0);
//    }
}