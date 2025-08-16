package com.rau.rau123456789.facade.impl;

import com.rau.rau123456789.application.SchoolService;
import com.rau.rau123456789.domain.School;
import com.rau.rau123456789.dto.SchoolDTO;
import com.rau.rau123456789.facade.SchoolFacade;
import com.rau.rau123456789.facade.assembler.SchoolAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
