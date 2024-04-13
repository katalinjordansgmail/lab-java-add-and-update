package com.ironhack.controller;

import com.ironhack.DTO.EmployeeDepartmentOnlyDTO;
import com.ironhack.DTO.EmployeeStatusOnlyDTO;
import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.model.enums.Status;
import com.ironhack.service.PatientService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/patients/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getByPatientId(@PathVariable int patientId) {
        return patientService.getByPatientId(patientId);
    }

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllByDateOfBirthBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
        return patientService.getAllByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllByAdmittedByDepartment(@RequestParam String department) {
        return patientService.getAllByAdmittedByDepartment(department);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody @Valid Patient patient) {
        patientService.save(patient);
    }

    @PutMapping("/patients/{patientId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable int patientId, @RequestBody @Valid Patient patient) {
        patientService.update(patientId, patient);
    }
}
