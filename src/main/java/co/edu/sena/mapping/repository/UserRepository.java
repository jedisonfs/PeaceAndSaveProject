package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> save(User user);

    List<User> saveAll(Iterable users);

    @Query("select u from User u where u.login = ?1")
    Optional<User> findByLogin(String login);

    List<User> findAll();

    User findById(int id);


    @Transactional(readOnly = true)
    Optional<User> findUserByLogin(String login);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.login = ?1 WHERE u.id = ?2")
    int updateLogin(String login, int id);

    List<User> findByLoginLike(String search);

    boolean existsByLogin(String login);

    void deleteByLogin(String login);

    void deleteAll(Iterable user);
}
