package com.rau.rau123456789.facade.assembler;

import com.rau.rau123456789.domain.School;
import com.rau.rau123456789.dto.SchoolDTO;
import org.mapstruct.Mapper;

import java.awt.*;

@Mapper(componentModel = "spring")
public interface SchoolAssembler {
    SchoolDTO toDto(School school);
    School toEntity(SchoolDTO dto);
}
