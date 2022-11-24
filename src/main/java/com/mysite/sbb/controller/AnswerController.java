package com.mysite.sbb.controller;

import com.mysite.sbb.domain.Question;
import com.mysite.sbb.service.AnswerService;
import com.mysite.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/answer")
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id")Integer id, @RequestParam String content){//post요청
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }

}
