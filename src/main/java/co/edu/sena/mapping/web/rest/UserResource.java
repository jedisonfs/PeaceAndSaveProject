package co.edu.sena.mapping.web.rest;

import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{login}")
    public ResponseEntity<User> getByLoginUser(@PathVariable String login) {
        User user = userRepository.findByLogin(login).get();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser() {
        List users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/user")
    public ResponseEntity<User> insertUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user/all")
    public ResponseEntity<List<User>> insertAllUsers(@Valid @RequestBody List<User> users) {
        userRepository.saveAll(users);
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/{id}")
    public void deleteByIdUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteAllUser() {
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
