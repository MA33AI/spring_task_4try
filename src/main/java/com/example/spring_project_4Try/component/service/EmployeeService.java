
package com.example.spring_project_4Try.component.service;

import com.example.spring_project_4Try.enumeration.StatusEmployee;
import com.example.spring_project_4Try.exception.EmployeeExceptionHandler.EmployeeNotFoundByIdException;
import com.example.spring_project_4Try.exception.EmployeeExceptionHandler.EmployeeNotFoundByNameException;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.entity.EmployeeEntity;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import com.example.spring_project_4Try.programObject.mapper.employeeMapper.EmployeeDtoMapper;
import com.example.spring_project_4Try.programObject.mapper.employeeMapper.EmployeeEntityMapper;
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
        initEmployeeInAddressesAndPhones(employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeDtoMapper.toDto(employeeEntity);
    }

    private void initEmployeeInAddressesAndPhones(EmployeeEntity employeeEntity) {
        initEmployeeInAddresses(employeeEntity);
        initEmployeeInPhones(employeeEntity);
    }

    private void initEmployeeInAddresses(EmployeeEntity employeeEntity) {
        for (AddressEntity address : employeeEntity.getAddresses()) {
            address.setEmployeeEntity(employeeEntity);
        }
    }

    private void initEmployeeInPhones(EmployeeEntity employeeEntity) {
        for (TelephoneEntity telephone : employeeEntity.getPhones()) {
            telephone.setEmployeeEntity(employeeEntity);
        }
    }

    public List<EmployeeRestDto> getAllEmployees() {

        List<EmployeeEntity> employees = new ArrayList<>();
        employees.addAll(employeeRepository.findAll());
        return employeeDtoMapper.toDtos(employees);
    }

    public EmployeeRestDto getById(UUID employeeid) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public List<EmployeeRestDto> getByName(String name) {

        List<EmployeeEntity> employeeData = employeeRepository.findByName(name);
        if (!employeeData.isEmpty())
            return employeeDtoMapper.toDtos(employeeData);
        else
            throw new EmployeeNotFoundByNameException(name);
    }

    public EmployeeRestDto changeToInactive(UUID employeeid) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setStatus(StatusEmployee.INACTIVE);
            employeeRepository.save(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public EmployeeRestDto changeToActive(UUID employeeid) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);

        if (employeeOptional.isPresent()) {
            employeeOptional.get().setStatus(StatusEmployee.ACTIVE);
            employeeRepository.save(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public EmployeeRestDto changeName(UUID employeeid, String name) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setName(name);
            employeeRepository.save(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public EmployeeRestDto changeAddress(UUID employeeid, List<AddressEntity> addresses) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setAddresses(addresses);
            employeeRepository.save(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public EmployeeRestDto changeTelephone(UUID employeeid, List<TelephoneEntity> phones) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setPhones(phones);
            employeeRepository.save(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public EmployeeRestDto deleteTelephone(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setPhones(null);
            employeeRepository.save(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }

    public EmployeeRestDto deleteEmployee(@RequestParam("employee_id") UUID employeeid) {

        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employeeid);
        if (employeeOptional.isPresent()) {
            employeeRepository.delete(employeeOptional.get());
            return employeeDtoMapper.toDto(employeeOptional.get());
        } else {
            throw new EmployeeNotFoundByIdException(employeeid);
        }
    }
}




