package com.example.spring_project_4Try.repository;

import com.example.spring_project_4Try.programObject.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

    List<EmployeeModel> findByName(String name);

    Optional<EmployeeModel> findById(UUID id);
}
