package co.edu.sena.mapping.repository;

//import co.edu.sena.mapping.domain.TypeDocument;
//import co.edu.sena.mapping.domain.enums.Condition;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeDocumentRepositoryTest {
//
//
//    @Autowired
//    TypeDocumentRepository typeDocumentRepository;
//
//    @Test
//    @Order(1)
//    void insert() {
//        TypeDocument typeDocument = new TypeDocument();
//        typeDocument.setInitil("T.I");
//        typeDocument.setDocumentName("Tarjeta identidad");
//        typeDocument.setTypeDocumentState(Condition.ACTIVO);
//
//        typeDocumentRepository.save(typeDocument);
//        TypeDocument typeDocument2 = typeDocumentRepository.findByInitial("T.I");
//
//        assertEquals(typeDocument2.getInitial(), typeDocument.getInitial());
//    }
//
//    @Test
//    @Order(2)
//    void insertAll() {
//        TypeDocument typeDocument = new TypeDocument();
//        typeDocument.setInitil("C.E");
//        typeDocument.setDocumentName("Cedula extranjeria");
//        typeDocument.setTypeDocumentState(Condition.ACTIVO);
//
//        TypeDocument typeDocument2 = new TypeDocument();
//        typeDocument2.setInitil("C.C");
//        typeDocument2.setDocumentName("Cedula ciudadania");
//        typeDocument2.setTypeDocumentState(Condition.ACTIVO);
//
//        List<TypeDocument> lisTypeDocument = new ArrayList<TypeDocument>();
//        lisTypeDocument.add(typeDocument);
//        lisTypeDocument.add(typeDocument2);
//
//        typeDocumentRepository.saveAll(lisTypeDocument);
//        assertEquals(lisTypeDocument, lisTypeDocument);
//    }
//
//    @Test
//    @Order(3)
//    void findById() {
//        TypeDocument typeDocument = typeDocumentRepository.findByInitial("C.C");
//        assertEquals(typeDocument.getInitial(), typeDocument.getInitial());
//
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List<TypeDocument> listTypeDocument = typeDocumentRepository.findAll();
//        assertNotNull(listTypeDocument);
//    }
//
//    @Test
//    @Order(5)
//    void findByInitialLike() {
//        List<TypeDocument> listTypeDocument = typeDocumentRepository.findByInitialLike("C");
//        assertNotNull(listTypeDocument);
//    }
//
//    @Test
//    @Order(6)
//    void existsById() {
//        boolean typeDocumenty = typeDocumentRepository.existsByInitial("C.E");
//        assertTrue(typeDocumenty);
//    }
//
//    @Test
//    @Order((7))
//    void update(){
//        TypeDocument typeDocument = typeDocumentRepository.findById(20);
//        typeDocument.setInitil("C.E");
//        typeDocumentRepository.save(typeDocument);
//        TypeDocument typeDocument1 = typeDocumentRepository.findByInitial("C.E");
//        assertEquals(typeDocument.getInitial(),typeDocument1.getInitial());
//    }
//
//    @Test
//    @Order(8)
//    void deleteByInitial() {
//        typeDocumentRepository.deleteById(10);
//        assertEquals(typeDocumentRepository.count(), 2);
//    }
//
//    @Test
//    @Order(9)
//    void deleteAll() {
//        List<TypeDocument> typesDocument = typeDocumentRepository.findAll();
//        typeDocumentRepository.deleteAll(typesDocument);
//        assertTrue(typeDocumentRepository.count() == 0);
//    }
}
