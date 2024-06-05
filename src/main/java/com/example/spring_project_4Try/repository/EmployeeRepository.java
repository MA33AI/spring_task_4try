package com.example.spring_project_4Try.repository;

import com.example.spring_project_4Try.programObject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    List<Employee> findByName(String name);

    Optional<Employee> findById(UUID id);
}
