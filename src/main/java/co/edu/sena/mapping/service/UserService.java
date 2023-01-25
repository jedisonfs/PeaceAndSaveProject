package co.edu.sena.mapping.service;

import co.edu.sena.mapping.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    User save(User user);

    List<User> saveAll(Iterable users);

    void addToRoleToUser(String login, String role);

    User findByLogin(String login);

    List<User> findAll();

    User findById(int id);
}
