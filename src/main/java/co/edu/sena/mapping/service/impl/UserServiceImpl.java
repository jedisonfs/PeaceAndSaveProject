package co.edu.sena.mapping.service.impl;

import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.service.UserService;
import co.edu.sena.mapping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /*
    UserDetails para cargar datos de usuario y seguridad
    este metodo busca en la base de datos si el usuario existe y si es asi
    crea un UserDetails es cual enviara la informacion para poder crear el Token
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("The username " + username + "not found"));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getRole()));
        });

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswordHash(), authorities);
    }

    @Override
    public User save(User user) {
        log.info("Saving new user {} to the database", user.getLogin());
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(Iterable users) {
        List<User> insertBatch = userRepository.saveAll(users);
        return insertBatch;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }


}
