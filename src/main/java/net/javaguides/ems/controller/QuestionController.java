package net.javaguides.ems.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.QuestionDto;
import net.javaguides.ems.entity.Questions;
import net.javaguides.ems.repository.QuestionRepository;
import net.javaguides.ems.repository.McqAnswerKeysRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.ems.entity.Questions;
import net.javaguides.ems.entity.McqAnswerKeys;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@AllArgsConstructor
public class QuestionController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QuestionRepository  questionRepository;

    @Autowired
    private McqAnswerKeysRepository mcqAnswerKeysRepository;

    @PostMapping("/create")
    public ResponseEntity<QuestionDto> createQuestion(@Valid @RequestBody QuestionDto questionDto) {
        Questions question = new Questions();
        question.setQuestionType(questionDto.getQuestionType());
        question.setQuestion(questionDto.getQuestion());
        question.setTitle(questionDto.getTitle());
        question.setStatus(questionDto.getStatus());
        question.setDescription(questionDto.getDescription());
        List <McqAnswerKeys>  mcqAnswerKeysList = new ArrayList<>();
        questionDto.getMcqAnswerKeysDto().forEach(mcqAnswerKeysDto -> {
            McqAnswerKeys mcqAnswerKeys = new McqAnswerKeys();
            mcqAnswerKeys.setOptionName(mcqAnswerKeysDto.getOptionName());
            mcqAnswerKeys.setOptionText(mcqAnswerKeysDto.getOptionText());
            mcqAnswerKeys.setIsCorrect(mcqAnswerKeysDto.getIsCorrect());
            mcqAnswerKeys.setMark(mcqAnswerKeysDto.getMark());
            mcqAnswerKeysRepository.save(mcqAnswerKeys);
            mcqAnswerKeysList.add(mcqAnswerKeys);
        });
        mcqAnswerKeysList.forEach(mcqAnswerKeys -> System.out.println(mcqAnswerKeys.getOptionName()));
        //save Question
        Questions savedQuestion = questionRepository.save(question);
        logger.info("Question created successfully: " + savedQuestion);
        return  new ResponseEntity<>(questionDto, HttpStatus.CREATED);
    }
}
