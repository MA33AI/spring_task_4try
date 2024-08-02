package com.example.spring_project_4Try.programObject.entity;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class EmployeeEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 30, message = "Name need be between 1 and 30")
    private String name;
    @NotNull(message = "Status cannot be null")
    @Enumerated
    private StatusEmployee status;
    @NotEmpty(message = "List phones cannot be null")
    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TelephoneEntity> phones;
    @NotEmpty(message = "List addresses cannot be null")
    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime createdUp;
}

