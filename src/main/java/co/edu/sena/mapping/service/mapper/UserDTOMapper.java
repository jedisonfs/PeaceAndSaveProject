package co.edu.sena.mapping.service.mapper;

import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {


    public UserDTO apply(User user) {
        return new UserDTO(user.getId(),
                user.getLogin(),
                user.getEmail(),
                user.getActivated(),
                user.getCreatedBy(),
                user.getCreatedDate(),
                user.getLastModifiedBy(),
                user.getLastModifiedDateBy());
    }

}
