package com.rau.rau123456789.controller;

import com.rau.rau123456789.dto.SchoolDTO;
import com.rau.rau123456789.facade.SchoolFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
