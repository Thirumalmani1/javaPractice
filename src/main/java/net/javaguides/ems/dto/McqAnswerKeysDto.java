package net.javaguides.ems.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class McqAnswerKeysDto {

    @NotBlank(message = "Type cannot be blank")
    private Long questionId;

    @NotBlank(message = "Type cannot be blank")
    @Size(min = 1, max = 50, message = "option name must be between 1 and 50 characters")
    private String optionName;

    @NotBlank(message = "Type cannot be blank")
    @Size(min = 1, max = 250, message = "option name must be between 1 and 50 characters")
    private String optionText;

    @NotBlank(message = "isCorrect cannot be blank")
    private Boolean isCorrect;

    @NotBlank(message = "mark cannot be blank")
    private Long mark;

    private Date createdAt;

    private LocalDateTime updatedAt;
}
