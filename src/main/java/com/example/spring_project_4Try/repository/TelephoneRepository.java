package com.example.spring_project_4Try.repository;

import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TelephoneRepository extends JpaRepository<TelephoneEntity, UUID> {

    Optional<TelephoneEntity> findById(UUID id);
}

