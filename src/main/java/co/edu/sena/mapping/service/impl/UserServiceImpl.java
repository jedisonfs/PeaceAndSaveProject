package co.edu.sena.mapping.service.impl;

import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.service.UserService;
import co.edu.sena.mapping.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public Optional<User> save(User user) {
        Optional<User> newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public List<User> saveAll(Iterable users) {
        List<User> insertBatch = userRepository.saveAll(users);
        return insertBatch;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

}