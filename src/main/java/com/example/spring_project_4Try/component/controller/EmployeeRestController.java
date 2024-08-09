
package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.EmployeeService;
import com.example.spring_project_4Try.exception.BusinessException;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
import com.example.spring_project_4Try.programObject.entity.AddressEntity;
import com.example.spring_project_4Try.programObject.entity.TelephoneEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
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
    public EmployeeRestDto createEmployee(@Valid @RequestBody EmployeeRestDto employeeRestDTO) throws BusinessException {
        return employeeService.createEmployee(employeeRestDTO);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeRestDto> getAllEmployees() throws BusinessException {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getById")
    public EmployeeRestDto getById(@Valid @RequestParam("id") UUID id) throws BusinessException {
        return employeeService.getById(id);
    }

    @GetMapping("/getByName")
    public List<EmployeeRestDto> getByName(@Valid @RequestParam("name") String name) throws BusinessException {
        return employeeService.getByName(name);
    }

    @PatchMapping("/changeToInactive")
    public EmployeeRestDto changeToInactive(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return employeeService.changeToInactive(employeeid);
    }

    @PatchMapping("/changeToActive")
    public EmployeeRestDto changeToActive(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return employeeService.changeToActive(employeeid);
    }

    @PatchMapping("/changeName")
    public EmployeeRestDto changeName(@Valid @RequestParam("employee_id") UUID employeeid, @RequestParam("name") String name) throws BusinessException {
        return employeeService.changeName(employeeid, name);
    }

    @PatchMapping("/changeAddress")
    public EmployeeRestDto changeAddress(@Valid @RequestParam("employee_id") UUID employeeid, @RequestParam("address") List<AddressEntity> addresses) throws BusinessException {
        return employeeService.changeAddress(employeeid, addresses);
    }

    @PatchMapping("/changeTelephone")
    public EmployeeRestDto changeTelephone(@Valid @RequestParam("employee_id") UUID employeeid, @RequestParam("telephone") List<TelephoneEntity> phones) throws BusinessException {
        return employeeService.changeTelephone(employeeid, phones);
    }

    @DeleteMapping("/deleteTelephone")
    public EmployeeRestDto deleteTelephone(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException {
        return employeeService.deleteTelephone(employeeid);
    }

    @DeleteMapping("/deleteEmployee")
    public EmployeeRestDto deleteEmployee(@Valid @RequestParam("employee_id") UUID employeeid) throws BusinessException{
        return employeeService.deleteEmployee(employeeid);
    }
}


