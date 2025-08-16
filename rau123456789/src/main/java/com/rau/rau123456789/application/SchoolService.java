package com.rau.rau123456789.application;

import com.rau.rau123456789.domain.School;

import java.util.List;

public interface   SchoolService {
    School createSchool(School school);

    List<School> getAllSchools();

    void deleteSchool(Long id);

    School updateSchool(Long id, School s);
}
