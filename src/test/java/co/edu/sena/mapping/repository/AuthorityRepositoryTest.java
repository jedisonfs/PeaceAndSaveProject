package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.Authority;
//import co.edu.sena.mapping.domain.Instructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorityRepositoryTest {

    void test (){
        Assertions.assertTrue(true);
    }
//    @Autowired
//    private AuthorityRepository authorityRepository;
//
//    @Test
//    @Order(1)
//    void findByName() {
//        Authority authority = authorityRepository.findByName("Instructor");
//        assertNotNull(authority);
//    }
//
//    @Test
//    @Order(2)
//    void findAll() {
//        List<Authority> authorities = authorityRepository.findAll();
//        assertNotNull(authorities);
//    }
//
//    @Test
//    @Order(3)
//    void save() {
//        Authority authority1 = new Authority();
//        authority1.setName("Instructor");
//        authorityRepository.save(authority1);
//        Authority authority = authorityRepository.findByName("Instructor");
//        assertEquals(authority.getName(), authority1.getName());
//    }
//
//    @Test
//    @Order(4)
//    void saveAll() {
//        Authority authority = new Authority();
//        Authority authority2 = new Authority();
//        authority.setName("Responsable");
//        authority2.setName("Administrador");
//
//        List<Authority> listAuthority = new ArrayList<Authority>();
//        listAuthority.add(authority);
//        listAuthority.add(authority2);
//
//        authorityRepository.saveAll(listAuthority);
//        assertEquals(listAuthority, listAuthority);
//    }
//
//    @Test
//    @Order(5)
//    void update() {
//        int authority = authorityRepository.updateAuthority("instructor", "Instructor");
//        Authority authority1 = authorityRepository.findByName("instructor");
//        assertEquals(authority1.getName(), "instructor");
//    }
//
//    @Test
//    @Order(6)
//    void existsById() {
//        boolean authority = authorityRepository.existsByName("Instructor");
//        assertTrue(authority);
//    }
//
//    @Test
//    @Order(7)
//    void deleteById() {
//        authorityRepository.deleteByName("Instructor");
//        assertEquals(authorityRepository.count(), 3);
//    }
//
//    @Test
//    @Order(8)
//    void deleteAll() {
//        List<Authority> listAuthority = authorityRepository.findAll();
//        authorityRepository.deleteAll(listAuthority);
//        assertTrue(authorityRepository.count()==0);
//    }
}
