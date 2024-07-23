package net.javaguides.ems.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguides.ems.dto.McqAnswerKeysDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    @NotBlank(message = "Type cannot be blank")
    @Size(min = 1, max = 50, message = "Type must be between 1 and 50 characters")
    private String questionType;

    @NotBlank(message = "Type cannot be blank")
    private String question;
    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String description;

    private Boolean status;

    private List<McqAnswerKeysDto> mcqAnswerKeysDto;
}
