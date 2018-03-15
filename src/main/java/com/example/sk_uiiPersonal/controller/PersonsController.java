package com.example.sk_uiiPersonal.controller;

import com.example.sk_uiiPersonal.exception.ResourceNotFoundException;
import com.example.sk_uiiPersonal.model.Persons;
import com.example.sk_uiiPersonal.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PersonsController {

	@Autowired
    PersonsRepository personsRepository;

    // Get All Persons
    @GetMapping("/persons")
    public List<Persons> getAllPersons() {
        return personsRepository.findAll();
    }
	
    // Create a new Persons
    @PostMapping("/persons") 
    public Persons createPersons(@Valid @RequestBody Persons persons) {
        return personsRepository.save(persons);
    }

    // Get a Single Persons
    @GetMapping("/persons/{id}")
    public Persons getByIdPersons(@PathVariable(value = "id") Integer id) {
        return personsRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Persons", "id", id));
    }
    
    // Update a Persons
    @PutMapping("/persons/{id}")
    public Persons updatePersons(@PathVariable(value = "id") Integer id,
                           @Valid @RequestBody Persons detail) {

    	Persons persons = personsRepository.findById(id)
        				.orElseThrow(() -> new ResourceNotFoundException("Persons", "id", id));
    	persons.setAddress(detail.getAddress());
    	persons.setBirth_date(detail.getBirth_date());
    	persons.setBirth_place(detail.getBirth_place());
    	persons.setGender(detail.getGender());
    	persons.setDivisions(detail.getDivisions());
    	persons.setMajors(detail.getMajors());
    	persons.setName(detail.getName());
    	persons.setPhone_number(detail.getPhone_number());

        Persons updatedPersons = personsRepository.save(persons);
        return updatedPersons;
    }
    
    // Delete a Persons
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deletePersons(@PathVariable(value = "id") Integer id) {
        Persons persons = personsRepository.findById(id)
                			.orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

        personsRepository.delete(persons);

        return ResponseEntity.ok().build();
    }
}