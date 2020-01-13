package com.example.controller;

import com.example.entity.Customer;
import com.example.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http requests from frontend
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customers")
@RequiredArgsConstructor

public class CustomerController {

    ICustomerService customerService;
    public CustomerController(ICustomerService customerService) {
        this.customerService=customerService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Customer findById(@PathVariable  int id) {
        return customerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public void addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.save(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.save(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    public void deleteCustomerById(@PathVariable int id) {
        customerService.deleteById(id);
    }
}
