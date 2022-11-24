package com.mysite.sbb.controller;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.domain.Question;
import com.mysite.sbb.domain.QuestionForm;
import com.mysite.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/question")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question/question_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question/question_detail";
    }
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question/question_form";
    }
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){//BindingResult -> @Vaild로 검증된 데이터
        if(bindingResult.hasErrors()){
            return "question/question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
