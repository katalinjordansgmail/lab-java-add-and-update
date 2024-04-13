package com.ironhack.controller;

import com.ironhack.DTO.EmployeeDepartmentOnlyDTO;
import com.ironhack.DTO.EmployeeStatusOnlyDTO;
import com.ironhack.model.Employee;
import com.ironhack.model.enums.Status;
import com.ironhack.service.EmployeeService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getByEmployeeId(@PathVariable int employeeId) {
        return employeeService.getByEmployeeId(employeeId);
    }

    @GetMapping("/employees/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllByStatus(@PathVariable Status status) {
        return employeeService.getAllByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllByDepartment(@PathVariable String department) {
        return employeeService.getAllByDepartment(department);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody @Valid Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping("/employees/{employeeId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable int employeeId, @RequestBody @Valid Employee employee) {
            employeeService.update(employeeId, employee);
        }

    @PatchMapping("/employees/{employeeId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdateStatus(@PathVariable int employeeId, @RequestBody @NotNull EmployeeStatusOnlyDTO partialEmployee) {
            employeeService.updateStatus(employeeId, partialEmployee.getStatus());
    }

    @PatchMapping("/employees/{employeeId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void partialUpdateDepartment(@PathVariable int employeeId, @RequestBody @NotNull EmployeeDepartmentOnlyDTO partialEmployee) {
        employeeService.updateDepartment(employeeId, partialEmployee.getDepartment());
    }
}