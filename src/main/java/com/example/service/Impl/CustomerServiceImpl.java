package com.example.service.Impl;

import com.example.dao.ICustomerRepo;
import com.example.entity.Customer;
import com.example.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(int id) {
       Optional<Customer> result = customerRepo.findById(id);
       Customer customer = null;

       if (result.isPresent()) {
          customer = result.get();
       }
       else {
           throw new RuntimeException("Did not find customer id " + "id");
       }
           return customer;

    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public String deleteById(int id) {
        customerRepo.deleteById(id);
        return "customer has been deleted!";
    }
}
