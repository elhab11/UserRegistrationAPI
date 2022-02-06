package com.techbeesolutions.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbeesolutions.Exception.RecordNotFoundException;
import com.techbeesolutions.Model.Customer;
import com.techbeesolutions.Model.CustomerRepository;

import antlr.collections.List;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class CostomerService {

    
    @Autowired
    CustomerRepository repository;
     
    public List getAllCustomers()
    {
        java.util.List<Customer> CustomersList = repository.findAll();
         
        if(CustomersList.size() > 0) {
            return (List) CustomersList;
        } else {
            return (List) new ArrayList<Customer>();
        }
    }
     
    public Customer getCustomerById(Long id) throws RecordNotFoundException 
    {
        java.util.Optional<Customer> customer = repository.findById(id);
         
        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }
     
    public Customer createOrUpdateCustomere(Customer entity) throws RecordNotFoundException 
    {
        java.util.Optional<Customer> Customer = repository.findById(entity.getId());
         
        if(Customer.isPresent()) 
        {
            Customer newEntity = Customer.get();
            newEntity.setEmailAdress(entity.getEmailAdress());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setUserName(entity.getUserName());
            newEntity.setAge(entity.getAge());
            newEntity.setPhoneNumber(entity.getPhoneNumber());
            
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteCustomerById(Long id) throws RecordNotFoundException 
    {
        java.util.Optional<Customer> customer = repository.findById(id);
         
        if(customer.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    } 
}
