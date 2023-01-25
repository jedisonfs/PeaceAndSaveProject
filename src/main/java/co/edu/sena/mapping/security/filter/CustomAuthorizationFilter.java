package co.edu.sena.mapping.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.tracing.dtrace.DTraceProviderFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

/*
Esta clase se encarga de revisar cada una de las peticiones de ingreso de la aplicaion
y toma el token los valida y decide si esta autorizado a ingresar a que REQUEST en especifico
y decide quien no tiene permiso a ingresar a la aplicacion
 */

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    /*
    Este metodo tiene dos filtros internos los cuales revisan una por una de las solicitudes
    y deciden si autoriza continuar o no
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        /*
        Los primero es validar que el token viene de la ruta del LOGIN que se tiene
        definido
         */

        if (request.getServletPath().equals("/api/login/")) {
            // El filtreChain le esta diciendo que si es correcta la ruta le permite contiunar con el siguiente filtro
            filterChain.doFilter(request, response);
        } else {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

                try {
                    String token = authorizationHeader.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes()); // Utilizar el mismo algoritmo de codificacion del TOKEN para poder validar que es correcto

                    JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = jwtVerifier.verify(token); // Verificar que el token es correcto

                    String username = decodedJWT.getSubject(); // Devolver el nombre del usuario
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class); // En los claims eston los roles porque en la clase CustomerFilter se define asi

                /*
                Se hace esta conversion ya que Spring Security valida que los roles
                vengan de la clase SimpleGrantedAUthority y nos permitea validar que de todos
                los roles que tiene esta clase esta el que el usuario tiene
                 */
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    stream(roles).forEach(role -> {
                        authorities.add(new SimpleGrantedAuthority(role));
                    });

                /*
                Crea el las credenciasles del token y revisar que es el verdadero
                autorizado
                 */
                    UsernamePasswordAuthenticationToken
                            authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    log.error("Error logging inn: {}", e.getMessage());
                    response.setHeader("error", e.getMessage());
                    response.setStatus(FORBIDDEN.value());
//                    response.setndError(FORBIDDEN.value());

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
                filterChain.doFilter(request, response);
            }
        }
    }
}
