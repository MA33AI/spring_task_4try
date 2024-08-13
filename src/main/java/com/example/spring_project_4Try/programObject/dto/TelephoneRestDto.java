package com.example.spring_project_4Try.programObject.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelephoneRestDto {

    @Id
    private UUID id;
    private String codeCountry;
    private String codeCity;
    private String number;
}
