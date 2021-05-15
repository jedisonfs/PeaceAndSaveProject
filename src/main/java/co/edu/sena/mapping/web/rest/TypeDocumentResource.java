package co.edu.sena.mapping.web.rest;

import co.edu.sena.mapping.domain.TypeDocument;
import co.edu.sena.mapping.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeDocumentResource {

    @Autowired
    TypeDocumentRepository typeDocumentRepository;

    @GetMapping("/type-document/initial/{initial}")
    public ResponseEntity<TypeDocument> getInitialTypeDocument(@PathVariable String initial) {
        TypeDocument typeDocument = typeDocumentRepository.findByInitial(initial);
        return ResponseEntity.ok().body(typeDocument);
    }

    @GetMapping("/type-document")
    public ResponseEntity<List<TypeDocument>> getAllTypeDocument() {
        List<TypeDocument> query = typeDocumentRepository.findAll();
        return ResponseEntity.ok().body(query);
    }

    @PostMapping("/type-document")
    public ResponseEntity<TypeDocument> insert(@Valid @RequestBody TypeDocument typeDocument) {
        typeDocumentRepository.save(typeDocument);
        return ResponseEntity.ok().body(typeDocument);
    }

    @PostMapping("/type-document/insertAll")
    public ResponseEntity<List<TypeDocument>> insertAllTypeDocument(@Valid @RequestBody List<TypeDocument> typeDocuments) {
        typeDocumentRepository.saveAll(typeDocuments);
        return ResponseEntity.ok().body(typeDocuments);
    }

    @PutMapping("/type-document")
    public ResponseEntity<TypeDocument> updateByIdTypeDocument(@Valid @RequestBody TypeDocument typeDocument) {
        typeDocumentRepository.save(typeDocument);
        return ResponseEntity.ok(typeDocument);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/typeDocument/{id}")
    public void deleteByIdTypeDocument(@PathVariable int id) {
        typeDocumentRepository.deleteById(id);
    }

    @DeleteMapping("/typeDocument")
    public ResponseEntity<Void> deleteAllTypeDocument() {
        typeDocumentRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
