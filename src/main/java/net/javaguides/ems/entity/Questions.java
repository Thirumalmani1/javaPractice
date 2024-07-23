package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="question_type")
    private String questionType;

    @Column(name ="question")
    private String question;

    @Column(name="title")
    private String title;

    @Column(name ="description")
    private String description;

    @Column(name ="status")
    private Boolean status;
}
