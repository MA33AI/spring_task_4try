
package com.example.spring_project_4Try.programObject.mapper.telephoneMapper;

import com.example.spring_project_4Try.programObject.dto.TelephoneRestDto;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TelephoneEntityMapper {

    TelephoneEntity toEntity(TelephoneRestDto dto);

    List<TelephoneEntity> toEntities(List<TelephoneRestDto> dtos);
}

