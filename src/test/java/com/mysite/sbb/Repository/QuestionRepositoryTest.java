package com.mysite.sbb.Repository;

import com.mysite.sbb.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Test
    void testJpa(){
        Question q  = this.questionRepository.findBySubject("스프링이란 뭘까요?");
        assertEquals(11,q.getId());
    }
    @Test
    void testJpa2(){
        Question q  = this.questionRepository.findBySubjectAndContent("스프링이란 뭘까요?", "스프링이랑 스프링부트의 차이에 대해서 알고 싶습니다.");
        assertEquals(11,q.getId());
    }
    @Test
    void testJpa3(){
        List<Question>qList = this.questionRepository.findBySubjectLike("스프링%");
        Question q = qList.get(0);
        assertEquals("스프링이란 뭘까요?", q.getSubject());
    }
    @Test
    void testJpa4(){
        Optional<Question>oq = this.questionRepository.findById(11);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }
    @Test
    void testJpa5(){
        assertEquals(2, this.questionRepository.count());
        Optional<Question>oq = this.questionRepository.findById(11);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1,this.questionRepository.count());
    }
}