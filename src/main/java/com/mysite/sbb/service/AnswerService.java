package com.mysite.sbb.service;

import com.mysite.sbb.Repository.AnswerRepository;
import com.mysite.sbb.domain.Answer;
import com.mysite.sbb.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);//답변 저장로직
    }
}
