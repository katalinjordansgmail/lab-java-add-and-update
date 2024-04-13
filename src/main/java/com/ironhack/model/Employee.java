package com.ironhack.model;

import com.ironhack.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employees")
@Data
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;
    @Valid
    private Status status;

    public Employee(int employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}