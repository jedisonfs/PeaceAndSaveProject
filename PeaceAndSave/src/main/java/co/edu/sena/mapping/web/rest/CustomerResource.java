package co.edu.sena.mapping.web.rest;

import co.edu.sena.mapping.domain.Customer;
import co.edu.sena.mapping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer/{documentNumber}")
    public ResponseEntity<Customer> getByNumberDocument(@PathVariable String documentNumber) {
        Customer customer = customerRepository.findByDocumentNumber(documentNumber);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/customer/all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> insertCustomer(@Valid @RequestBody Customer customer) {
        customer = customerRepository.save(customer);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer/all")
    public ResponseEntity<List<Customer>> insertAllCustomers(@Valid @RequestBody List<Customer> customers) {
        customerRepository.saveAll(customers);
        return ResponseEntity.ok().body(customers);
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
        if (customer.getId() != null) {
            return ResponseEntity.badRequest().build();
        } else {
            customerRepository.save(customer);
            return ResponseEntity.ok().body(customer);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/customer/{id}")
    public void deleteByDocumentNumberCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
    }

    @DeleteMapping("/customer")
    public ResponseEntity<Void> deleteAllCustomer() {
        return ResponseEntity.ok().build();
    }
}
