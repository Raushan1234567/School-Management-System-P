package com.rau.rau123456789.facade.impl;

import com.rau.rau123456789.application.SchoolService;
import com.rau.rau123456789.domain.School;
import com.rau.rau123456789.dto.SchoolDTO;
import com.rau.rau123456789.facade.SchoolFacade;
import com.rau.rau123456789.facade.assembler.SchoolAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SchoolFacadeImpl implements SchoolFacade {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolAssembler schoolAssembler;

    @Override
    public SchoolDTO createSchool(SchoolDTO schoolDTO) {
        // Convert DTO -> Entity
        School school = schoolAssembler.toEntity(schoolDTO);

        // Save entity using service
        School savedSchool = schoolService.createSchool(school);

        // Convert Entity -> DTO and return
        return schoolAssembler.toDto(savedSchool);
    }

    @Override
    public List<SchoolDTO> getAllSchools() {
        // Fetch all schools from service
        List<School> schools = schoolService.getAllSchools();

        // Convert entity list -> DTO list
        return schools.stream()
                .map(schoolAssembler::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchool(Long id) {
        schoolService.deleteSchool(id);
    }

    @Override
    public SchoolDTO updateSchool(Long id, SchoolDTO schoolDTO) {

        School s=schoolAssembler.toEntity(schoolDTO);
       School updatedSchool = schoolService.updateSchool(id,s);

        return schoolAssembler.toDto(updatedSchool);
    }
}
