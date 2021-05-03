package com.expleo.banking.service;

import com.expleo.banking.exception.CustomerNotFoundException;
import com.expleo.banking.model.Customer;
import com.expleo.banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> retrieveAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    public Customer retrieveCustomerById(Integer id){

        Customer customer = customerRepository.find(id);

        if ( customer == null ) {
            throw new CustomerNotFoundException(String.format("customer Not found for the given id : %s", id ) );
        }
        return customer;
    }

    public void deleteById(Integer id) {

        customerRepository.deleteById(id);
    }

}