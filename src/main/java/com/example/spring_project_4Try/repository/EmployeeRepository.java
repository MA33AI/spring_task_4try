package com.example.spring_project_4Try.repository;

import com.example.spring_project_4Try.programObject.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {

    List<EmployeeEntity> findByName(String name);

    Optional<EmployeeEntity> findById(UUID id);
}
