package com.rau.rau123456789.controller;

import com.rau.rau123456789.dto.SchoolDTO;
import com.rau.rau123456789.facade.SchoolFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/schools")
public class SchoolController {

    @Autowired
    private SchoolFacade schoolFacade;

    @PostMapping
    @Operation(summary = "Create a new school", description = "Creates and returns a newly created school.")
    public ResponseEntity<SchoolDTO> createSchool(@RequestBody SchoolDTO schoolDTO) {
        SchoolDTO createdSchool = schoolFacade.createSchool(schoolDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
    }

    @GetMapping
    @Operation(summary = "Get all schools", description = "Fetches and returns a list of all schools.")
    public ResponseEntity<List<SchoolDTO>> getAllSchools() {
        List<SchoolDTO> schools = schoolFacade.getAllSchools();
        return ResponseEntity.ok(schools);
    }

    // ✅ Delete school by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a school", description = "Deletes a school by its ID.")
    public ResponseEntity<Void> deleteSchoolById(@PathVariable Long id) {
        schoolFacade.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Patch school by ID (partial update)
    @PatchMapping("/{id}")
    @Operation(summary = "Update a school", description = "Partially updates a school's details by ID.")
    public ResponseEntity<SchoolDTO> updateSchool(@PathVariable Long id, @RequestBody SchoolDTO schoolDTO) {
        SchoolDTO updatedSchool = schoolFacade.updateSchool(id, schoolDTO);
        return ResponseEntity.ok(updatedSchool);
    }
}
