package com.example.sk_uiiPersonal.controller;

import com.example.sk_uiiPersonal.exception.ResourceNotFoundException;
import com.example.sk_uiiPersonal.model.Majors;
import com.example.sk_uiiPersonal.repository.MajorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MajorsController {

	@Autowired
    MajorsRepository majorsRepository;

    // Get All Majors
    @GetMapping("/majors")
    public List<Majors> getAllMajors() {
        return majorsRepository.findAll();
    }
	
    // Create a new Majors
    @PostMapping("/majors") 
    public Majors createMajors(@Valid @RequestBody Majors majors) {
        return majorsRepository.save(majors);
    }

    // Get a Single Majors
    @GetMapping("/majors/{id}")
    public Majors getByIdMajors(@PathVariable(value = "id") Integer id) {
        return majorsRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Majors", "id", id));
    }
    
    // Update a Majors
    @PutMapping("/majors/{id}")
    public Majors updateMajors(@PathVariable(value = "id") Integer id,
                           @Valid @RequestBody Majors detail) {

    	Majors majors = majorsRepository.findById(id)
        				.orElseThrow(() -> new ResourceNotFoundException("Majors", "id", id));
    	majors.setDesc_major(detail.getDesc_major());
    	majors.setId_faculty(detail.getId_faculty());
    	majors.setName_major(detail.getName_major());

    	Majors updatedMajors = majorsRepository.save(majors);
        return updatedMajors;
    }
    
    // Delete a Majors
    @DeleteMapping("/majors/{id}")
    public ResponseEntity<?> deleteMajors(@PathVariable(value = "id") Integer id) {
    	Majors majors = majorsRepository.findById(id)
                			.orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

    	majorsRepository.delete(majors);

        return ResponseEntity.ok().build();
    }
}