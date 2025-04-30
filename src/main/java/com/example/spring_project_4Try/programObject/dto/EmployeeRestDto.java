package com.example.spring_project_4Try.programObject.dto;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRestDto {

    @Id
    private UUID id;
    private String name;
    private StatusEmployee status;
    private List<AddressRestDto> addresses;
    private List<TelephoneRestDto> phones;
}






