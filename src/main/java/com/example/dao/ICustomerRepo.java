package com.example.dao;

import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
    //We do not need to wirte any CRUD operations code.
    //Spring Framework will handle this for us.
}
