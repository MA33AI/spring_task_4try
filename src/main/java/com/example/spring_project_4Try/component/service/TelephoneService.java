
package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.exception.NotFoundException;
import com.example.spring_project_4Try.programObject.dto.TelephoneRestDto;
import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import com.example.spring_project_4Try.programObject.mapper.telephoneMapper.TelephoneDtoMapper;
import com.example.spring_project_4Try.programObject.mapper.telephoneMapper.TelephoneEntityMapper;
import com.example.spring_project_4Try.repository.EmployeeRepository;
import com.example.spring_project_4Try.repository.TelephoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelephoneService {

    private final TelephoneRepository telephoneRepository;
    private final EmployeeRepository employeeRepository;
    private final TelephoneDtoMapper telephoneDtoMapper;
    private final TelephoneEntityMapper telephoneEntityMapper;

    public TelephoneRestDto createTelephone(TelephoneRestDto telephoneRestDto){

        UUID employeeid = telephoneRestDto.getIdEmployee();
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeid);
        TelephoneEntity telephoneEntity = telephoneEntityMapper.toEntity(telephoneRestDto);
        if(employeeEntity.isPresent()){
            telephoneEntity.setEmployeeEntity(employeeEntity.get());
            telephoneRepository.save(telephoneEntity);
            TelephoneRestDto telephoneRestDtoOut = telephoneDtoMapper.toDto(telephoneEntity);
            telephoneRestDtoOut.setIdEmployee(employeeid);
            return telephoneRestDtoOut;
        }
        else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }
}

