package com.example.sk_uiiPersonal.controller;

import com.example.sk_uiiPersonal.exception.ResourceNotFoundException;
import com.example.sk_uiiPersonal.model.Divisions;
import com.example.sk_uiiPersonal.repository.DivisionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DivisionsController {

	@Autowired
    DivisionsRepository divisionsRepository;

    // Get All Divisions
    @GetMapping("/divisions")
    public List<Divisions> getAllDivisions() {
        return divisionsRepository.findAll();
    }
	
    // Create a new Divisions
    @PostMapping("/divisions") 
    public Divisions createDivisions(@Valid @RequestBody Divisions divisions) {
        return divisionsRepository.save(divisions);
    }

    // Get a Single Divisions
    @GetMapping("/divisions/{id}")
    public Divisions getByIdDivisions(@PathVariable(value = "id") Integer id) {
        return divisionsRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Divisions", "id", id));
    }
    
    // Update a Divisions
    @PutMapping("/divisions/{id}")
    public Divisions updateDivisions(@PathVariable(value = "id") Integer id,
                           @Valid @RequestBody Divisions detail) {

    	Divisions divisions = divisionsRepository.findById(id)
        				.orElseThrow(() -> new ResourceNotFoundException("Divisions", "id", id));
    	divisions.setDesc_division(detail.getDesc_division());
    	divisions.setName_division(detail.getName_division());

    	Divisions updatedDivisions = divisionsRepository.save(divisions);
        return updatedDivisions;
    }
    
    // Delete a Divisions
    @DeleteMapping("/divisions/{id}")
    public ResponseEntity<?> deleteDivisions(@PathVariable(value = "id") Integer id) {
    	Divisions divisions = divisionsRepository.findById(id)
                			.orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

    	divisionsRepository.delete(divisions);

        return ResponseEntity.ok().build();
    }
}