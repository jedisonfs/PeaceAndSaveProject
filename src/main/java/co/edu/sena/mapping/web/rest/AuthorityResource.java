package co.edu.sena.mapping.web.rest;

import co.edu.sena.mapping.domain.Authority;
import co.edu.sena.mapping.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorityResource {

//    @Autowired
//    AuthorityRepository authorityRepository;
//
//    @GetMapping("/authority/{name}")
//    public ResponseEntity<Authority> getByIdAuthority(@PathVariable String name) {
//        Authority authority = authorityRepository.findByName(name);
//        return ResponseEntity.ok().body(authority);
//    }
//
//    @GetMapping("/authority")
//    public ResponseEntity<List<Authority>> getAllAuhtority() {
//        List<Authority> authorities = authorityRepository.findAll();
//        return ResponseEntity.ok().body(authorities);
//    }
//
//    @PostMapping("/authority")
//    public ResponseEntity<Authority> insertAuthority(@Valid @RequestBody Authority authority) {
//        authorityRepository.save(authority);
//        return ResponseEntity.ok().body(authority);
//    }
//
//    @PostMapping("/authority/all")
//    public ResponseEntity<List<Authority>> insertAllAuthority(@Valid @RequestBody List<Authority> authorities) {
//        authorityRepository.saveAll(authorities);
//        return ResponseEntity.ok().body(authorities);
//    }
//
////    @PutMapping("/authority")
////    public ResponseEntity<Authority> updateByIdAuthority(@Valid @RequestBody Authority authority) {
////        if (authority.getName() == null) {
////            return ResponseEntity.badRequest().build();
////        } else {
////            Authority result = authorityRepository.save(authority);
////            return ResponseEntity.ok().build();
////        }
////    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/authority/{name}")
//    public void deleteByIdAuthority(@PathVariable String name) {
//        authorityRepository.deleteByName(name);
//    }
//
//    @DeleteMapping("/authority")
//    public ResponseEntity<Void> deleteAllAuthority() {
//        authorityRepository.deleteAll();
//        return ResponseEntity.ok().build();
//    }
}
