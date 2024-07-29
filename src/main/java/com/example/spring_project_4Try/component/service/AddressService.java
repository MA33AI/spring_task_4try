
package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.component.controller.AddressRestController;
import com.example.spring_project_4Try.exception.NotFoundException;
import com.example.spring_project_4Try.programObject.dto.AddressRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
import com.example.spring_project_4Try.programObject.mapper.addressMapper.AddressDtoMapper;
import com.example.spring_project_4Try.programObject.mapper.addressMapper.AddressEntityMapper;
import com.example.spring_project_4Try.repository.AddressRepository;
import com.example.spring_project_4Try.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;
    private final AddressDtoMapper addressDtoMapper;
    private final AddressEntityMapper addressEntityMapper;

    public AddressRestDto createAddress(AddressRestDto addressRestDto){

        UUID employeeid = addressRestDto.getIdEmployee();
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        AddressEntity addressEntity = addressEntityMapper.toEntity(addressRestDto);
        if(employeeOptional.isPresent()){
            addressEntity.setEmployeeEntity(employeeOptional.get());
            addressRepository.save(addressEntity);
            AddressRestDto addressRestDtoOut = addressDtoMapper.toDto(addressEntity);
            addressRestDtoOut.setIdEmployee(employeeid);
            return addressRestDtoOut;
        }
        else{
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }
}
