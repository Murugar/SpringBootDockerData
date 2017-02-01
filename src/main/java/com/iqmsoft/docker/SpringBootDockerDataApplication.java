package com.iqmsoft.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.docker.docker.model.Customer;
import com.iqmsoft.docker.docker.model.Person;
import com.iqmsoft.docker.docker.model.Vendor;
import com.iqmsoft.docker.docker.repos.CustomerRepository;
import com.iqmsoft.docker.docker.repos.PersonRepository;
import com.iqmsoft.docker.docker.repos.VendorRepository;

import java.util.Date;

@SpringBootApplication
public class SpringBootDockerDataApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	VendorRepository vendorRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerDataApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		System.out.println("Mongodb works..:");
		System.out.println("-------------------------------");
		customerRepository.deleteAll();

		// save a couple of customers
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}

		System.out.println("MYSQL works..:");
		System.out.println("-------------------------------");

		personRepository.save(new Person(new Date(), "Ahmet Oz", "3493409324", "bilmuhahmet@gmail.com" ));

		for (Person p : personRepository.findAll()){
			System.out.println(p);
		}
		
		vendorRepository.save(new Vendor(new Date(), "Ahmet Oz", "3493409324", "bilmuhahmet@gmail.com" ));

		for (Vendor p : vendorRepository.findAll()){
			System.out.println(p);
		}
	}
}
