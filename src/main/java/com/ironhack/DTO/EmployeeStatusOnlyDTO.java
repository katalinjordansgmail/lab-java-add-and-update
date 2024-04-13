package com.ironhack.DTO;

import com.ironhack.model.enums.Status;
import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class EmployeeStatusOnlyDTO {
    @Valid
    private Status status;
}
