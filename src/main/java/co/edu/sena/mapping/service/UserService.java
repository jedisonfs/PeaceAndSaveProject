package co.edu.sena.mapping.service;

import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.service.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    User addUser(User user);

    List<User> saveAllUsers(Iterable users);

//    void addToRoleToUser(String login, String role);

    UserDTO findByLogin(String login);

    List<UserDTO> findAllUsers();

    List<User> findAllUser();

    UserDTO findUserById(int id);

    List<UserDTO> findUserByLoginLike(String search);

    boolean existsByLogin(String login);

    void deleteUserByLogin(String login);

}
