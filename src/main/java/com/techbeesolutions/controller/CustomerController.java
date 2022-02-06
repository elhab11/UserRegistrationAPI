package com.techbeesolutions.controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbeesolutions.services.CostomerService;
import com.techbeesolutions.Exception.RecordNotFoundException;
import com.techbeesolutions.Model.*;

import antlr.collections.List;

@RestController
@RequestMapping("/customers")
public class CustomerController 
{
    @Autowired
    CostomerService service;
 
    @GetMapping
    public ResponseEntity<List> getAllCustomers() {
        List list = service.getAllCustomers();
 
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getEmployeeById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
    	Customer entity = service.getCustomerById(id);
 
        return new ResponseEntity<Customer>(entity, HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Customer> createOrUpdateEmployee(Customer customer)
                                                    throws RecordNotFoundException {
    	Customer updated = service.createOrUpdateCustomere(customer);
        return new ResponseEntity<Customer>(updated, HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        service.deleteCustomerById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}