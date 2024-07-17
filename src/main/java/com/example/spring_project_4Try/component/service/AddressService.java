
package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.programObject.dto.AddressRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.mapper.addressMapper.AddressDtoMapper;
import com.example.spring_project_4Try.programObject.mapper.addressMapper.AddressEntityMapper;
import com.example.spring_project_4Try.repository.AddressRepository;
import com.example.spring_project_4Try.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressDtoMapper addressDtoMapper;
    private final AddressEntityMapper addressEntityMapper;

    public AddressRestDto createAddress(AddressRestDto addressRestDto){

        AddressEntity addressEntity = addressEntityMapper.toEntity(addressRestDto);
        addressRepository.save(addressEntity);
        return addressDtoMapper.toDto(addressEntity);
    }
}
