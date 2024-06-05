package com.example.spring_project_4Try.component.controller;

import com.example.spring_project_4Try.component.service.EmployeeService;
import com.example.spring_project_4Try.programObject.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/getAllEmployees")
    public java.util.List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getById")
    public Employee getById(@RequestParam("id") java.util.UUID id) throws Exception {
        return employeeService.getByIdOrThrown(id);
    }

    @GetMapping("/getByName")
    public java.util.List<Employee> getByName(@RequestParam("name") String name) throws Exception {
        return employeeService.getByNameOrThrown(name);
    }

    @PatchMapping("/changeToInactive")
    public Employee changeToInactive(@RequestParam("employee_id") java.util.UUID employeeid) {
        return employeeService.changeToInactiveOrThrow(employeeid);
    }

    @PatchMapping("/changeToActive")
    public Employee changeToActive(@RequestParam("employee_id") java.util.UUID employeeid) {
        return employeeService.changeToActiveOrThrow(employeeid);
    }


    @PatchMapping("/changeName")
    public Employee changeName(@RequestParam("employee_id") java.util.UUID employeeid, @RequestParam("name") String name) {
        return employeeService.changeNameOrThrow(employeeid, name);
    }

    @PatchMapping("/changeAddress")
    public Employee changeAddress(@RequestParam("employee_id") java.util.UUID employeeid, @RequestParam("address") String address) {
        return employeeService.changeAddressOrThrow(employeeid, address);
    }

    @PatchMapping("/changeTelephone")
    public Employee changeTelephone(@RequestParam("employee_id") java.util.UUID employeeid, @RequestParam("telephone") Integer telephone) {
        return employeeService.changeTelephoneOrThrow(employeeid, telephone);
    }

    @DeleteMapping("/deleteTelephone")
    public Employee deleteTelephone(@RequestParam("employee_id") java.util.UUID employeeid) {
        return employeeService.deleteTelephoneOrThrow(employeeid);
    }
}
