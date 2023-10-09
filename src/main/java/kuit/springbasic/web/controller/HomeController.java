package kuit.springbasic.web.controller;

import kuit.springbasic.web.domain.Question;
import kuit.springbasic.web.repository.QuestionRepository;
import kuit.springbasic.web.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuestionService questionService;

    @RequestMapping("/")
    public String showHome(Model model){
        List<Question> questions = questionService.findQuestions();
        model.addAttribute("questions",questions);
        return "/home";
    }
}
