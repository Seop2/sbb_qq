package com.mysite.sbb.controller;

import com.mysite.sbb.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;
    @RequestMapping("/question/list")
//    @ResponseBody
    public String list(){
        return "question_list";
    }
}
