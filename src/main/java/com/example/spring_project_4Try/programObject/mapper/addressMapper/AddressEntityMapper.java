
package com.example.spring_project_4Try.programObject.mapper.addressMapper;

import com.example.spring_project_4Try.programObject.dto.AddressRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressEntityMapper {

    AddressEntity toEntity(AddressRestDto dto);

    List<AddressEntity> toEntities(List<AddressRestDto> dtos);
}

