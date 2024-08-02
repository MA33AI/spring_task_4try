package com.example.spring_project_4Try.programObject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AddressEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Size(min = 1, max = 20, message = "Country need be between 1 and 20")
    private String country;
    @Size(min = 1, max = 20, message = "Region need be between 1 and 20")
    private String region;
    @Size(min = 1, max = 20, message = "City need be between 1 and 20")
    private String city;
    @Size(min = 1, max = 20, message = "City need be between 1 and 20")
    private String street;
    @Size(min = 1, max = 20, message = "City need be between 1 and 10")
    private String house;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime createdUp;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private EmployeeEntity employeeEntity;
}


