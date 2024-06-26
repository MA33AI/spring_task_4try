package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.EmployeeService;
import com.example.spring_project_4Try.programObject.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
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
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getById")
    public EmployeeDTO getById(@RequestParam("id") UUID id) throws Exception {
        return employeeService.getById(id);
    }

    @GetMapping("/getByName")
    public List<EmployeeDTO> getByName(@RequestParam("name") String name) throws Exception {
        return employeeService.getByName(name);
    }

    @PatchMapping("/changeToInactive")
    public EmployeeDTO changeToInactive(@RequestParam("employee_id") UUID employeeid) {
        return employeeService.changeToInactive(employeeid);
    }

    @PatchMapping("/changeToActive")
    public EmployeeDTO changeToActive(@RequestParam("employee_id") UUID employeeid) {
        return employeeService.changeToActive(employeeid);
    }

    @PatchMapping("/changeName")
    public EmployeeDTO changeName(@RequestParam("employee_id") UUID employeeid, @RequestParam("name") String name) {
        return employeeService.changeName(employeeid, name);
    }

    @PatchMapping("/changeAddress")
    public EmployeeDTO changeAddress(@RequestParam("employee_id") UUID employeeid, @RequestParam("address") String address) {
        return employeeService.changeAddress(employeeid, address);
    }

    @PatchMapping("/changeTelephone")
    public EmployeeDTO changeTelephone(@RequestParam("employee_id") UUID employeeid, @RequestParam("telephone") Integer telephone) {
        return employeeService.changeTelephone(employeeid, telephone);
    }

    @DeleteMapping("/deleteTelephone")
    public EmployeeDTO deleteTelephone(@RequestParam("employee_id") UUID employeeid) {
        return employeeService.deleteTelephone(employeeid);
    }
}
