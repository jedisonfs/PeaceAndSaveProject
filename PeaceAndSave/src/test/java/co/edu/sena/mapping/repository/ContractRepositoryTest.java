package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Contract;
import co.edu.sena.mapping.domain.Instructor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContractRepositoryTest {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Test
    @Order(1)
    void save() {
        Contract contract = new Contract();
        contract.setContractNumber(123456789);
        contract.setContractYear(new Date(2020 - 04 - 14));
        contractRepository.save(contract);
        Contract contract2 = contractRepository.findByContractNumber(123456789);
        assertEquals(contract.getContractNumber(), contract2.getContractNumber());
    }

    @Test
    @Order(2)
    void saveAll() {
        Contract contract = new Contract();
        contract.setContractNumber(159753456);
        contract.setContractYear(new Date(2018 - 04 - 14));

        Contract contract2 = new Contract();
        contract2.setContractNumber(987654321);
        contract2.setContractYear(new Date(2021 - 05 - 14));

        List contracts = new ArrayList();
        contracts.add(contract);
        contracts.add(contract2);

        contractRepository.saveAll(contracts);
        assertEquals(contracts, contracts);
    }

    @Test
    @Order(3)
    void updateContract() {
        int contract = contractRepository.updateContract(new Date(2007 - 06 - 18), 123456789);
        assertEquals(contract, 1);
    }

    @Test
    @Order(4)
    void findByContractNumber() {
        Contract contract = contractRepository.findByContractNumber(123456789);
        assertNotNull(contract);
    }

    @Test
    @Order(5)
    void findAll() {
        List contracts = (List) contractRepository.findAll();
        assertNotNull(contracts);
    }

    @Test
    @Order(6)
    void existsById() {
        boolean contract = contractRepository.existsById(39);
        assertTrue(contract);
    }

    @Test
    @Order(7)
    void deleteByContractNumber() {
        contractRepository.deleteByContractNumber(123456789);
        assertEquals(contractRepository.count(), 2);
    }

    @Test
    @Order(8)
    void deleteAll() {
        List contracts = (List) contractRepository.findAll();
        contractRepository.deleteAll(contracts);
        assertTrue(contractRepository.count() == 0);
    }
}