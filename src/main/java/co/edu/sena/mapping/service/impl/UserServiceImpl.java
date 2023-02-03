package co.edu.sena.mapping.service.impl;

import co.edu.sena.mapping.domain.Roles;
import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.repository.RoleRepository;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public User addUser(User user) {
        log.info("Saving new user {} to the database", user.getLogin());

//        user.setCreatedDate(new Date(format.format(user.getCreatedDate())));
//        user.setLastModifiedDateBy(new Date(format.format(user.getLastModifiedDateBy())));
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        return userRepository.save(user);
    }

    @Override
    public List<User> saveAllUsers(Iterable users) {
        return userRepository.saveAll(users);
    }

//    public void addToRoleToUser(String login, String role) {
//        User user = userRepository.findUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException("The username " + login + "not found"));
//        Roles rol = roleRepository.findByName(role);
//        user.getRoles().add(rol);
//    }

    @Override
    public UserDTO findByLogin(String login) {
        return userRepository.findByLogin(login).map(userDTOMapper).orElseThrow(() -> new UsernameNotFoundException("Not found username" + login));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> users = userRepository.findAll()
                .stream().map(userDTOMapper)
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO findUserById(int id) {
        return userRepository.findById(id).map(userDTOMapper).orElseThrow(() -> new UsernameNotFoundException("Not found identification  " + id + " of user"));
    }

    @Override
    public List<UserDTO> findUserByLoginLike(String search) {
        return userRepository.findByLoginLike(search).stream().map(userDTOMapper).collect(Collectors.toList());
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public void deleteUserByLogin(String login) {
        userRepository.deleteByLogin(login);
        if (!userRepository.existsByLogin(login)) {
            throw new UsernameNotFoundException(
                    "Username not find in data base");
        }
    }

}
