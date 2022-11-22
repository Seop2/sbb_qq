package com.mysite.sbb.Repository;

import com.mysite.sbb.domain.Answer;
import com.mysite.sbb.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnswerRepositoryTest {
    @Autowired
    private AnswerRepository answerRepository;
   @Autowired
   private  QuestionRepository questionRepository;
    @Test
    void TestJpa(){
        Optional<Question>oq = this.questionRepository.findById(12);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
    @Test
    public void 답변조회() throws Exception {
        //given
        Optional<Answer>oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(12, a.getQuestion().getId());
        //when
        
        //then
    }
    @Transactional
    @Test
    public void 답변조회2() throws Exception {
        //given
        Optional<Question>oq = this.questionRepository.findById(12);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();
        assertEquals(2,answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
        //when

        //then
    }

}