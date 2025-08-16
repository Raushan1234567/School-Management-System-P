package com.rau.rau123456789.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class SchoolDTO {

    private Long id;
    private String name;
    private String address;

    @Builder
    public SchoolDTO(Long id, String name, String address) {
        this.id=id;
        this.name = name;
        this.address = address;
    }
}
