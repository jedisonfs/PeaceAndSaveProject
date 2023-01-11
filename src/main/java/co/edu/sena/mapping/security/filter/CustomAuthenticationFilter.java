package co.edu.sena.mapping.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String password = request.getParameter("username");
        log.info("Username is: {}", username);
        log.info("Password is: {}", password);


        //especifica que el usuario desea autenticarse mediante un nombre de usuario y una contraseña.
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        //Se utiliza este AuthenticacionManager para pasarlo al
        //autentiar al usuario que esta intentando iniciar sesion
        return super.attemptAuthentication(request, response);
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
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
