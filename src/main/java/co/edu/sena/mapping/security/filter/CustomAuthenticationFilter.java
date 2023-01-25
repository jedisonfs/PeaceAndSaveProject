package co.edu.sena.mapping.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/*
Esta clase nos permite crear el TOKEN de acceso y los filtros indicaran si se autoriza el ingreso del usuario
a la aplicaicon o no
y ademas nos permite darle continuidad al usuario que esta intentando ingresar
para que puda utilizar las REQUEST, es decir si esta bien las credenciasles de username y password

En la CLASE UsernamePasswordAuthenticationFilter -> Es donde esta definido la ruta de la pagina de LOGIN
 */
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    /*
    Esto es el administrador de autenticacion para autenticar al usuario
     */
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("Username is: {}", username);
        log.info("Password is: {}", password);


        //especifica que el usuario desea autenticarse mediante un nombre de usuario y una contraseña.
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        //Se utiliza este AuthenticacionManager para pasarlo al
        //autentiar al usuario que esta intentando iniciar sesion
        return authenticationManager.authenticate(authenticationToken);
    }


    /*
    Metodo que nos permite enviar un Token de acceso y refrescar o actulizar el token
    siempre que el inicio de sesion sea exitosa. CUANDO EL INICIO DE SESION SEA EXITOSO
    SE LLAMA A ESTE METODO

    Este metodo se encarga de crear y enviar el token a la request
    este metodo toma la response y la request, esto se puede utilizar para pasar
    al encabezado o algo al cuerpo 
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

        /**
         Crear el token, con el Subject(datos del usuario)
         ExpiresAt -> Tiempo de expiracion
         Issuer -> Emisor quien genera el token
         Claim -> El que contien todas las partes del token
         **/
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withIssuer(request.getRequestURI().toString())// el emisor del token o nombre de la empresa
                .withClaim("roles",
                        user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .withIssuer(request.getRequestURI().toString())// el emisor del token o nombre de la empresa
                .sign(algorithm);

        /*
        Cada vez que el usuario inicie sesion correctamente
        se dirigira a este metodo y se agregan dos encabezados
        access_token y refresh_token
         */
        response.setHeader("access_token", access_token);
        response.setHeader("refresh_token", refresh_token);

        /*
        Este sera donde se alamcene el token de acceso y refresh
         */
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);

        /*
        ESTABLECER LA RESPUESTA SEA DE TIPO JSON
        Este guardara el token en la respuesta de la solicitud de inicios de sesion LOGIN
         */

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
}
