package com.example.service;

import com.example.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();
    public Customer findById(int id);
    public void save(Customer customer);
    public String deleteById(int id);
}
