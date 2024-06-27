package com.example.spring_project_4Try.programObject.mapper;

import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.model.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DtoMapper {

    EmployeeRestDto toDto(EmployeeEntity model);

    List<EmployeeRestDto> toDtos(List<EmployeeEntity> models);
}
