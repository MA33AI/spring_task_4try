
package com.example.spring_project_4Try.programObject.mapper.employeeMapper;

import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeDtoMapper {

    EmployeeRestDto toDto(EmployeeEntity entity);

    List<EmployeeRestDto> toDtos(List<EmployeeEntity> entities);
}


