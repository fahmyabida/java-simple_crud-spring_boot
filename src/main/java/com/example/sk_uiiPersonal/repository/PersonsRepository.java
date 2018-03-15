package com.example.sk_uiiPersonal.repository;

import com.example.sk_uiiPersonal.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Integer>  {

}
