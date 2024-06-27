package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import com.example.spring_project_4Try.exception.NotFoundException;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.mapper.DtoMapper;
import com.example.spring_project_4Try.programObject.mapper.EmployeeEntityMapper;
import com.example.spring_project_4Try.programObject.model.EmployeeEntity;
import com.example.spring_project_4Try.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper dtoMapper;
    private final EmployeeEntityMapper employeeEntityMapper;

    public EmployeeRestDto createEmployee(EmployeeRestDto employeeRestDTO) {

        EmployeeEntity employeeEntity = employeeEntityMapper.toEntity(employeeRestDTO);
        employeeRepository.save(employeeEntity);
        return dtoMapper.toDto(employeeEntity);
    }

    public List<EmployeeRestDto> getAllEmployees() {

        List<EmployeeEntity> employees = new ArrayList<>();
        employees.addAll(employeeRepository.findAll());
        return dtoMapper.toDtos(employees);
    }

    public EmployeeRestDto getById(UUID id) {

        Optional<EmployeeEntity> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            return dtoMapper.toDto(employeeData.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public List<EmployeeRestDto> getByName(String name) {

        List<EmployeeEntity> employeeData = employeeRepository.findByName(name);
        if (!employeeData.isEmpty())
            return dtoMapper.toDtos(employeeData);
        else
            throw new NotFoundException("Пользователь не найден");
    }

    public EmployeeRestDto changeToInactive(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setStatus(StatusEmployee.INACTIVE);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeRestDto changeToActive(UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);

        if (employee.isPresent()) {
            employee.get().setStatus(StatusEmployee.ACTIVE);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeRestDto changeName(UUID employeeid, String name) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setName(name);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeRestDto changeAddress(UUID employeeid, String address) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setAddress(address);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeRestDto changeTelephone(UUID employeeid, Integer telephone) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setTelephone(telephone);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeRestDto deleteTelephone(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setTelephone(null);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }
}
