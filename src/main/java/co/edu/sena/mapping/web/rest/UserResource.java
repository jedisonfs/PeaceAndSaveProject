package co.edu.sena.mapping.web.rest;

import co.edu.sena.mapping.domain.Roles;
import co.edu.sena.mapping.domain.User;
import co.edu.sena.mapping.repository.UserRepository;
import co.edu.sena.mapping.service.UserService;
import co.edu.sena.mapping.service.dto.UserDTO;
import co.edu.sena.mapping.web.rest.exception.EmptyInputException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.EMPTY;
import static org.springframework.http.HttpStatus.FORBIDDEN;


@RestController
@RequestMapping("/api")
@Slf4j
public class UserResource {

    @Autowired
    UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public UserResource(@Qualifier("serviceUser") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes()); // Utilizar el mismo algoritmo de codificacion del TOKEN para poder validar que es correcto

                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token); // Verificar que el token es correcto
                String username = decodedJWT.getSubject();
                User user = userRepository.findUserByLogin(username).orElseThrow(() -> new UsernameNotFoundException("No found username " + username));

                /**
                 Crear el un nuevo token, con el Subject(datos del usuario)
                 ExpiresAt -> Tiempo de expiracion
                 Issuer -> Emisor quien genera el token
                 Claim -> El que contien todas las partes del token
                 **/
                String access_token = JWT.create()
                        .withSubject(user.getLogin())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURI().toString())// el emisor del token o nombre de la empresa
                        .withClaim("roles",
                                user.getRoles().stream().map(Roles::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                /*
                Una ves creado el TOKEN JWT se debe enviar este como
                respuesta JSON en la solicitud
                 */

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                log.error("Error logging inn: {}", e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());

                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                    /*
                    ESTABLECER LA RESPUESTA SEA DE TIPO JSON
                    Este guardara el token en la respuesta de la solicitud de inicios de sesion LOGIN
                     */
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    @GetMapping("/user/{login}")
    public ResponseEntity<UserDTO> getByLoginUser(@PathVariable String login) {
        UserDTO user = userService.findByLogin(login);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> users = userService.findAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/user")
    public ResponseEntity<User> insertUser(@Valid @RequestBody User user) {

        if (user.getEmail().isEmpty() || user.getLogin().length() == 0) {
            throw new EmptyInputException("601", "Input Fields are empty");
        }
        return ResponseEntity.ok().body(userService.addUser(user));
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
