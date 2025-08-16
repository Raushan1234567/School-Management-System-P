package com.rau.rau123456789.application.impl;

import com.rau.rau123456789.application.SchoolService;
import com.rau.rau123456789.domain.School;
import com.rau.rau123456789.domain.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }
}
