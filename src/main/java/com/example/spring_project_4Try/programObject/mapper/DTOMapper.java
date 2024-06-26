package com.example.spring_project_4Try.programObject.mapper;

import com.example.spring_project_4Try.programObject.dto.EmployeeDTO;
import com.example.spring_project_4Try.programObject.model.EmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DTOMapper {

    EmployeeDTO toDto(EmployeeModel model);

    List<EmployeeDTO> toDtos(List<EmployeeModel> models);
}
