package co.edu.sena.mapping;

import antlr.BaseAST;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MappingApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String contraseña = passwordEncoder.encode("123456789");
//        $2a$10$b7765WgXtYEz2AfNx3ROwua9d7bgSHkS2TiYIl.8DSaozjXF9hIsm
        System.out.println(contraseña);
    }


}
