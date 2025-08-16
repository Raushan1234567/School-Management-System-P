package com.rau.rau123456789.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Builder
    public School(String address, Long id, String name) {
        this.address = address;
        this.id = id;
        this.name = name;
    }

    public void patch(School toBeUpdated){
        if(toBeUpdated.getName()!=null){
            this.name=toBeUpdated.getName();
        }
        if(toBeUpdated.getAddress()!=null){
            this.address=toBeUpdated.getAddress();
        }

    }

}
