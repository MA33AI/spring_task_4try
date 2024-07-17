
package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import com.example.spring_project_4Try.exception.NotFoundException;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import com.example.spring_project_4Try.programObject.mapper.employeeMapper.EmployeeDtoMapper;
import com.example.spring_project_4Try.programObject.mapper.employeeMapper.EmployeeEntityMapper;
import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
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
    private final EmployeeDtoMapper employeeDtoMapper;
    private final EmployeeEntityMapper employeeEntityMapper;

    public EmployeeRestDto createEmployee(EmployeeRestDto employeeRestDTO) {

        EmployeeEntity employeeEntity = employeeEntityMapper.toEntity(employeeRestDTO);
        employeeRepository.save(employeeEntity);
        return employeeDtoMapper.toDto(employeeEntity);
    }

    public List<EmployeeRestDto> getAllEmployees() {

        List<EmployeeEntity> employees = new ArrayList<>();
        employees.addAll(employeeRepository.findAll());
        return employeeDtoMapper.toDtos(employees);
    }

    public EmployeeRestDto getById(UUID employeeid) {

        Optional<EmployeeEntity> employeeData = employeeRepository.findById(employeeid);
        if (employeeData.isPresent()) {
            return employeeDtoMapper.toDto(employeeData.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public List<EmployeeRestDto> getByName(String name) {

        List<EmployeeEntity> employeeData = employeeRepository.findByName(name);
        if (!employeeData.isEmpty())
            return employeeDtoMapper.toDtos(employeeData);
        else
            throw new NotFoundException(String.format("Пользователь с именем - %s не найден", name));
    }

    public EmployeeRestDto changeToInactive(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setStatus(StatusEmployee.INACTIVE);
            employeeRepository.save(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public EmployeeRestDto changeToActive(UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);

        if (employee.isPresent()) {
            employee.get().setStatus(StatusEmployee.ACTIVE);
            employeeRepository.save(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public EmployeeRestDto changeName(UUID employeeid, String name) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setName(name);
            employeeRepository.save(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public EmployeeRestDto changeAddress(UUID employeeid, List<AddressEntity> addresses) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setAddresses(addresses);
            employeeRepository.save(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public EmployeeRestDto changeTelephone(UUID employeeid, List<TelephoneEntity> phones) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setPhones(phones);
            employeeRepository.save(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public EmployeeRestDto deleteTelephone(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employee.get().setPhones(null);
            employeeRepository.save(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }

    public EmployeeRestDto deleteEmployee(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employee = employeeRepository.findById(employeeid);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return employeeDtoMapper.toDto(employee.get());
        } else {
            throw new NotFoundException(String.format("Пользователь с id - %s не найден", employeeid));
        }
    }
}




