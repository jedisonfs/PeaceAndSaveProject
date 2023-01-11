package co.edu.sena.mapping.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserRepositoryTest {

    @Test
    void test() {
    }

//    @Autowired
////    UserRepository userRepository;
//
//    @Test
//    @Order(1)
//    void insert() {
//        User user = new User();
//        user.setId(1);
////        user.setLogin("jedisonfs");
//        user.setPasswordHash("123456789");
//        user.setEmail("edisonferia5@gmail.com");
//        user.setActivated(Condition.ACTIVO);
//        user.setCreatedBy("Edison Feria");
//        userRepository.save(user);
//        User user1 = userRepository.findByLogin("jedisonfs");
//        assertEquals(user1.getLogin(), user.getLogin());
//
//    }
//
//    @Test
//    @Order(2)
//    void insertAll() {
//        User user = new User();
//        user.setLogin("MmorenoIva");
//        user.setPasswordHash("123456789");
//        user.setEmail("marlonivañez4@gmail.com");
//        user.setActivated(Condition.ACTIVO);
//        user.setCreatedBy("Marlon Ivañez");
//
//        User user2 = new User();
//        user2.setLogin("jjohanfs");
//        user2.setPasswordHash("123456789");
//        user2.setEmail("johanferia5@gmail.com");
//        user2.setActivated(Condition.ACTIVO);
//        user2.setCreatedBy("Edison Feria");
//
//        List<User> listUsers = new ArrayList<>();
//        listUsers.add(user);
//        listUsers.add(user2);
//
//        userRepository.saveAll(listUsers);
//        assertEquals(listUsers, listUsers);
//
//    }
//
//    @Test
//    @Order(3)
//    void findId() {
//        User user = userRepository.findByLogin("jedisonfs");
//        assertNotNull(user);
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List<User> users = userRepository.findAll();
//        assertNotNull(users);
//    }
//
//    @Test
//    @Order(6)
//    void findByLoginLike() {
//        List<User> users = userRepository.findByLoginLike("j");
//        assertNotNull(users);
//    }
//
//    @Test
//    @Order(7)
//    void update() {
//        int user = userRepository.updateLogin("jedison", 1);
//        assertEquals(user, 1);
//    }
//
//    @Test
//    @Order(8)
//    void existsById() {
//        boolean user = userRepository.existsByLogin("jedisonfs");
//        assertTrue(user);
//    }
//
//    @Test
//    @Order(9)
//    void deleteById() {
//        userRepository.deleteByLogin("Mmorenolva");
//        assertEquals(userRepository.count(), 2);
//    }
//
//    @Test
//    @Order(10)
//    void deleteAll() {
//        List<User> listType = userRepository.findAll();
//        userRepository.deleteAll(listType);
//        assertTrue(userRepository.count()==0);
//    }
}