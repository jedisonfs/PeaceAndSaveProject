package co.edu.sena.mapping.service.impl;

import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.service.UserService;
import co.edu.sena.mapping.repository.UserRepository;
import co.edu.sena.mapping.service.dto.UserDTO;
import co.edu.sena.mapping.service.mapper.UserDTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service("serviceUser")
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDTOMapper userDTOMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDTOMapper = userDTOMapper;
    }

    /*
    UserDetails para cargar datos de usuario y seguridad
    este metodo busca en la base de datos si el usuario existe y si es asi
    crea un UserDetails es cual enviara la informacion para poder crear el Token
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username).orElseThrow(() -> new UsernameNotFoundException("The username " + username + "not found"));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswordHash(), authorities);
    }

    @Override
    public UserDTO addUser(User user) {
        log.info("Saving new user {} to the database", user.getLogin());
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        return userDTOMapper.apply(userRepository.save(user));
    }

    @Override
    public List<User> addAllUsers(Iterable users) {
        return userRepository.saveAll(users);
    }

    @Override
    public UserDTO findByLogin(String login) {
        return userRepository.findByLogin(login)
                .map(userDTOMapper).orElseThrow(() -> new UsernameNotFoundException("Not found username" + login));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> users = userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll().stream().map(userDTOMapper).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(int id) {
        return userRepository.findById(id)
                .map(userDTOMapper).orElseThrow(() -> {
                    log.info("Not found identificaction , {} , of user", id);
                    return new UsernameNotFoundException("Not found identification  " + id + " of user");
                });
    }

    @Override
    public List<UserDTO> findUserByLoginLike(String search) {
        return userRepository.findByLoginLike(search).stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public void updateUser(User user) {
        userRepository.updateLogin(user.getLogin(), user.getId());
        log.info(format("username [%s] ", user.getLogin()));
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public void deleteUserByLogin(String login) {
        userRepository.deleteByLogin(login);
        if (!userRepository.existsByLogin(login)) {
            log.info("Username not find in Data Base, {}", login);
            throw new UsernameNotFoundException(
                    "Username not find in data base");
        }
    }

    public void deleteUserById(int id) {
        if (!userRepository.existsById(id)) {
            throw new UsernameNotFoundException(
                    format("user with id [%s] not found", id)
            );
        }
        userRepository.deleteById(id);
    }
}
