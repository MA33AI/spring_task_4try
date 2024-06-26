package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import com.example.spring_project_4Try.exception.NotFoundException;
import com.example.spring_project_4Try.programObject.dto.EmployeeDTO;
import com.example.spring_project_4Try.programObject.mapper.DTOMapper;
import com.example.spring_project_4Try.programObject.mapper.ModelMapper;
import com.example.spring_project_4Try.programObject.model.EmployeeModel;
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
    private final DTOMapper dtoMapper;
    private final ModelMapper modelMapper;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        EmployeeDTO employeeDTOAdapter = new EmployeeDTO(UUID.randomUUID(), employeeDTO.getName(), employeeDTO.getAddress(), employeeDTO.getTelephone(), employeeDTO.getStatus());

        EmployeeModel employeeModel = modelMapper.toModel(employeeDTOAdapter);
        employeeRepository.save(employeeModel);
        return dtoMapper.toDto(employeeModel);
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeModel> employees = new ArrayList<>();
        employees.addAll(employeeRepository.findAll());
        return dtoMapper.toDtos(employees);
    }

    public EmployeeDTO getById(UUID id) {

        Optional<EmployeeModel> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            return dtoMapper.toDto(employeeData.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public List<EmployeeDTO> getByName(String name) {

        List<EmployeeModel> employeeData = employeeRepository.findByName(name);
        if (!employeeData.isEmpty())
            return dtoMapper.toDtos(employeeData);
        else
            throw new NotFoundException("Пользователь не найден");
    }

    public EmployeeDTO changeToInactive(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeModel> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setStatus(StatusEmployee.INACTIVE);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeDTO changeToActive(UUID employeeid) {

        Optional<EmployeeModel> employee = employeeRepository.findById(employeeid);

        if (employee.isPresent()) {
            employee.get().setStatus(StatusEmployee.ACTIVE);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeDTO changeName(UUID employeeid, String name) {

        Optional<EmployeeModel> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setName(name);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeDTO changeAddress(UUID employeeid, String address) {

        Optional<EmployeeModel> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setAddress(address);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeDTO changeTelephone(UUID employeeid, Integer telephone) {

        Optional<EmployeeModel> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setTelephone(telephone);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }

    public EmployeeDTO deleteTelephone(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeModel> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setTelephone(null);
            employeeRepository.save(employee.get());
            return dtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException("Пользователь не найден");
        }
    }
}
