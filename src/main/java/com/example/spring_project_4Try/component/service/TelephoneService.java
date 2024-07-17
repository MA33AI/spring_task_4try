
package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.programObject.dto.TelephoneRestDto;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import com.example.spring_project_4Try.programObject.mapper.telephoneMapper.TelephoneDtoMapper;
import com.example.spring_project_4Try.programObject.mapper.telephoneMapper.TelephoneEntityMapper;
import com.example.spring_project_4Try.repository.TelephoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelephoneService {

    private final TelephoneRepository telephoneRepository;
    private final TelephoneDtoMapper telephoneDtoMapper;
    private final TelephoneEntityMapper telephoneEntityMapper;

    public TelephoneRestDto createTelephone(TelephoneRestDto telephoneRestDto){

        TelephoneEntity telephoneEntity = telephoneEntityMapper.toEntity(telephoneRestDto);
        telephoneRepository.save(telephoneEntity);
        return telephoneDtoMapper.toDto(telephoneEntity);
    }
}

