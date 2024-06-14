package net.javaguides.ems.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="first_name", nullable = false, unique = true)
    @NotEmpty(message = "cannot be empty")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @NotEmpty(message = "cannot be empty")
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

}
