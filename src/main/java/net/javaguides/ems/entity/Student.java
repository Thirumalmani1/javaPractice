package net.javaguides.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message ="name cannot be null")
    @NotEmpty(message ="name cannot be empty")
    private String name;

    @NotEmpty(message ="passport number cannot be empty")
    @NotNull(message ="passport number cannot be null")
    private String passportNumber;

}
