package co.edu.sena.mapping.service.mapper;

import co.edu.sena.mapping.domain.Roles;
import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {


    @Override
    public UserDTO apply(User user) {
//        List<UserDTO> usersDTO = users.stream()
//                .peek(e -> log.info(e.toString()))
//                .map((user) -> {
//                    log.info("USER FIRST MAP " + user.toString());
//                    log.info("USER FIRST MAP " + user.getEmail());
//                    return new UserDTO(
//                            user.getId(),
//                            user.getLogin(),
//                            user.getEmail(),
//                            user.getActivated(),
//                            user.getCreatedBy(),
//                            user.getCreatedDate(),
//                            user.getLastModifiedBy(),
//                            user.getLastModifiedDateBy()
//                    );
//                })
//                .peek(e -> System.out.println("userDTO " + e.toString()))
//                .collect(Collectors.toList());
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        userDTO.setActivited(user.getActivated());
        userDTO.setCreateBy(user.getCreatedBy());
        userDTO.setCreatedDate(user.getCreatedDate());
        userDTO.setLastModifiedBy(user.getLastModifiedBy());
        userDTO.setLastModifiedDateBy(user.getLastModifiedDateBy());
        userDTO.setRoles((List<Roles>) user.getRoles());
        return userDTO;
    }

    public User apply(UserDTO userDTO) {

        User user = new User();
        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setActivated(userDTO.getActivited());
        user.setCreatedBy(userDTO.getCreateBy());
        user.setCreatedDate(userDTO.getCreatedDate());
        user.setLastModifiedBy(userDTO.getLastModifiedBy());
        user.setLastModifiedDateBy(userDTO.getLastModifiedDateBy());
        user.setRoles(userDTO.getRoles());

        return user;
    }

}
