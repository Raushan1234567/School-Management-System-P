package com.rau.rau123456789.facade;

import com.rau.rau123456789.dto.SchoolDTO;

import java.util.List;

public interface SchoolFacade {
    SchoolDTO createSchool(SchoolDTO schoolDTO);

    List<SchoolDTO> getAllSchools();

    void deleteSchool(Long id);

    SchoolDTO updateSchool(Long id, SchoolDTO schoolDTO);
}
