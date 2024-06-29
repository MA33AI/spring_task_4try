package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.EmployeeService;
import com.example.spring_project_4Try.programObject.dto.EmployeeRestDto;
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
    public EmployeeRestDto createEmployee(@RequestBody EmployeeRestDto employeeRestDTO) {
        return employeeService.createEmployee(employeeRestDTO);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeRestDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getById")
    public EmployeeRestDto getById(@RequestParam("id") UUID id) throws Exception {
        return employeeService.getById(id);
    }

    @GetMapping("/getByName")
    public List<EmployeeRestDto> getByName(@RequestParam("name") String name) throws Exception {
        return employeeService.getByName(name);
    }

    @PatchMapping("/changeToInactive")
    public EmployeeRestDto changeToInactive(@RequestParam("employee_id") UUID employeeid) {
        return employeeService.changeToInactive(employeeid);
    }

    @PatchMapping("/changeToActive")
    public EmployeeRestDto changeToActive(@RequestParam("employee_id") UUID employeeid) {
        return employeeService.changeToActive(employeeid);
    }

    @PatchMapping("/changeName")
    public EmployeeRestDto changeName(@RequestParam("employee_id") UUID employeeid, @RequestParam("name") String name) {
        return employeeService.changeName(employeeid, name);
    }

    @PatchMapping("/changeAddress")
    public EmployeeRestDto changeAddress(@RequestParam("employee_id") UUID employeeid, @RequestParam("address") String address) {
        return employeeService.changeAddress(employeeid, address);
    }

    @PatchMapping("/changeTelephone")
    public EmployeeRestDto changeTelephone(@RequestParam("employee_id") UUID employeeid, @RequestParam("telephone") Integer telephone) {
        return employeeService.changeTelephone(employeeid, telephone);
    }

    @DeleteMapping("/deleteTelephone")
    public EmployeeRestDto deleteTelephone(@RequestParam("employee_id") UUID employeeid) {
        return employeeService.deleteTelephone(employeeid);
    }
}
