package com.iqmsoft.docker.docker.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqmsoft.docker.docker.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {


}