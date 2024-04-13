package com.ironhack.service;

import com.ironhack.model.Employee;
import com.ironhack.model.enums.Status;
import com.ironhack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getByEmployeeId(int employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<Employee> getAllByStatus(Status status) {
        return employeeRepository.findAllByStatus(status);
    }

    public List<Employee> getAllByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(int employeeId, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            employee.setEmployeeId(employeeOptional.get().getEmployeeId());
        }
        employeeRepository.save(employee);
    }

    public void updateStatus(int employeeId, Status status) {
        Optional <Employee> employeeOptional = employeeRepository.findByEmployeeId(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setStatus(status);
            employeeRepository.save(employee);
        }
    }

    public void updateDepartment(int employeeId, String department) {
        Optional <Employee> employeeOptional = employeeRepository.findByEmployeeId(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
    }
}