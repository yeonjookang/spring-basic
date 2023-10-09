package kuit.springbasic.web.service;

import kuit.springbasic.web.domain.Question;
import kuit.springbasic.web.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findQuestions(){
        return questionRepository.findAll();
    }
}
