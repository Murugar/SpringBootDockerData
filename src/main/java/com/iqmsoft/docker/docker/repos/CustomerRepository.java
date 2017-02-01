package com.iqmsoft.docker.docker.repos;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iqmsoft.docker.docker.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

}