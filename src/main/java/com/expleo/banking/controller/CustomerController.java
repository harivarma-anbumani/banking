package com.expleo.banking.controller;

import com.expleo.banking.model.Customer;
import com.expleo.banking.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers")
    public List<Customer> retrieveAllCustomers()
    {
        return customerService.retrieveAllCustomer();
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<Customer> retrieveCustomer(@PathVariable Integer customerId) {
        log.info("Retrieve info for a Customer : {} ", customerId );
        return new ResponseEntity<Customer>( customerService.retrieveCustomerById( customerId ) , HttpStatus.OK);
    }

    @PostMapping(path = "/customer")
    public ResponseEntity<Object> save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCustomer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
    }
}
