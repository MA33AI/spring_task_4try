package com.example.spring_project_4Try.repository;

import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {

    Optional<AddressEntity> findById(UUID id);
}

