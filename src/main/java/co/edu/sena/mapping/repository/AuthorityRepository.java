package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.Authority;

import co.edu.sena.mapping.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AuthorityRepository  {

//    @Query("select a from  Authority a where a.name = ?1")
//    Authority findByName(String name);

//    @Query("select a from Authority a")
//    List<Authority> findAll();

//    Authority save(Authority authority);

//    Iterable<Authority> saveAll(Iterable listA);

//    @Transactional
//    @Modifying
//    @Query("Update Authority a SET a.name = ?1 where a.name = ?2")
//    int updateAuthority(String name, String name2);

//    boolean existsByName(String name);

//    void deleteByName(String name);

//    void deleteAll(Iterable authority);
}
