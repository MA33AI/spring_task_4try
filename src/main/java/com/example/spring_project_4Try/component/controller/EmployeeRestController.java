
package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.EmployeeService;
import com.example.spring_project_4Try.exception.BusinessException;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeRestDto> createEmployee(@Valid @RequestBody EmployeeRestDto employeeRestDTO) throws BusinessException {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRestDTO), HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeRestDto>> getAllEmployees() throws BusinessException {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<EmployeeRestDto> getById(@Valid @RequestParam("id") UUID id) throws BusinessException {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<EmployeeRestDto>> getByName(@Valid @RequestParam("name") String name) throws BusinessException {
        return new ResponseEntity<>(employeeService.getByName(name), HttpStatus.OK);
    }

    @PatchMapping("/changeToInactive")
    public ResponseEntity<EmployeeRestDto> changeToInactive(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return new ResponseEntity<>(employeeService.changeToInactive(employeeid), HttpStatus.OK);
    }

    @PatchMapping("/changeToActive")
    public ResponseEntity<EmployeeRestDto> changeToActive(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return new ResponseEntity<>(employeeService.changeToActive(employeeid), HttpStatus.OK);
    }

    @PatchMapping("/changeName")
    public ResponseEntity<EmployeeRestDto> changeName(@Valid @RequestParam("employee_id") UUID employeeid, @RequestParam("name") String name) throws BusinessException {
        return new ResponseEntity<>(employeeService.changeName(employeeid, name), HttpStatus.OK);
    }

    @PatchMapping("/changeAddress")
    public ResponseEntity<EmployeeRestDto> changeAddress(@Valid @RequestParam("employee_id") UUID employeeid, @RequestParam("address") List<AddressEntity> addresses) throws BusinessException {
        return new ResponseEntity<>(employeeService.changeAddress(employeeid, addresses), HttpStatus.OK);
    }

    @PatchMapping("/changeTelephone")
    public ResponseEntity<EmployeeRestDto> changeTelephone(@Valid @RequestParam("employee_id") UUID employeeid, @RequestParam("telephone") List<TelephoneEntity> phones) throws BusinessException {
        return new ResponseEntity<>(employeeService.changeTelephone(employeeid, phones), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTelephone")
    public ResponseEntity<EmployeeRestDto> deleteTelephone(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return new ResponseEntity<>(employeeService.deleteTelephone(employeeid), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<EmployeeRestDto> deleteEmployee(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeid), HttpStatus.OK);
    }
}


