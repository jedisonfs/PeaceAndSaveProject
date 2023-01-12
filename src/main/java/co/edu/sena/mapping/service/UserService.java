package co.edu.sena.mapping.service;

import co.edu.sena.mapping.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User save(User user);

    List<User> saveAll(Iterable users);

    Optional<User> findByLogin(String login);

    Optional<List<User>> findAll();

    Optional<User> findById(int id);
}
