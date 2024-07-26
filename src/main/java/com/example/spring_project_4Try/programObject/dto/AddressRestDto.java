package com.example.spring_project_4Try.programObject.dto;

import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRestDto {

    @Id
    private UUID id;
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private UUID idEmployee;
}


