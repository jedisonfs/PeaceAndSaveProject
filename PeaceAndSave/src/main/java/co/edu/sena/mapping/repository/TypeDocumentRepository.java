package co.edu.sena.mapping.repository;

import co.edu.sena.mapping.domain.TypeDocument;

import co.edu.sena.mapping.domain.enums.Condition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

public interface TypeDocumentRepository extends CrudRepository<TypeDocument, Integer> {

	TypeDocument save(TypeDocument typedocument);

	Iterable<TypeDocument> saveAll(Iterable typeDocument);

	@Query("select t from TypeDocument t where t.initial = ?1")
	TypeDocument findByInitial(String initial);

	TypeDocument findById(int id);

	List<TypeDocument> findAll();

	List<TypeDocument> findByInitialLike(String seacrh);

	@Transactional
	@Modifying
	@Query("UPDATE TypeDocument t SET t.initial = 'C.E' WHERE t.initial = ?2")
	int updateTypeDocumentState(String initial,int id);

	boolean existsByInitial(String initial);

	void deleteById(int id);

	void deleteAll(Iterable typeDocument);
}
