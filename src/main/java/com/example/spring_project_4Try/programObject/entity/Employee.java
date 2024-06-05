package com.example.spring_project_4Try.programObject.entity;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private java.util.UUID id;
    private String name;
    private String address;
    private Integer telephone;
    @Enumerated
    private StatusEmployee status;
}
