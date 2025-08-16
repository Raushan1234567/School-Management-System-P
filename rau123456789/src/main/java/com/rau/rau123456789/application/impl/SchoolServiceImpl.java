package com.rau.rau123456789.application.impl;

import com.rau.rau123456789.application.SchoolService;
import com.rau.rau123456789.domain.School;
import com.rau.rau123456789.domain.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public School updateSchool(Long id, School s) {
        School existingSchool = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));

        existingSchool.patch(s);

        return schoolRepository.save(existingSchool);
    }


}
