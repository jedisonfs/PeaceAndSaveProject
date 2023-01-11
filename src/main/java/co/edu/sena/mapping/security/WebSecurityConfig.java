package co.edu.sena.mapping.security;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

//    private static final Logger logger = Logger.getLogger("webConfigSecurity");
//    private static final Logger LOGCONSOLE = Logger.getLogger("CONSOLE");

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    /*
Cargara usuarios en memoria
Primero se prueba los usuarios en memoria y luego se valida con base de datos
*/
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("1234567"))
                .roles()
                .build());

        return manager;
    }


    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        //return httpSecurity.getSharedObject(AuthenticationManager.class)
        return null;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encrypdata = new BCryptPasswordEncoder();

        return encrypdata;
    }

}
