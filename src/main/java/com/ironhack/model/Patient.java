package com.ironhack.model;

import com.ironhack.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Table(name = "patients")
@Data
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Patient {
    @Id
    private int patientId;
    private String name;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee admittedBy;

    public Patient(int patientId, String name, Date dateOfBirth, Employee admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}