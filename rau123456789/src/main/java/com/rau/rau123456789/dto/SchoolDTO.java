package com.rau.rau123456789.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class SchoolDTO {
    private String name;
    private String address;

    @Builder
    public SchoolDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
