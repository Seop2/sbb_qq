package com.mysite.sbb.service;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.domain.Question;
import com.mysite.sbb.domain.SiteUser;
import com.mysite.sbb.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//이 책은 간결한 설명을 위해 별도의 DTO를 만들지 않고 엔티티 객체를 컨트롤러와 타임리프에서 그대로 사용할 것이다.
// 하지만 실제 업무 프로그램을 작성할 때는 엔티티 클래스를 대신할 DTO 클래스를 만들어 사용하기를 권한다.
@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }
    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);//id의 값에 해당하는 데이터가 없을 경우 예외처리
        if(question.isPresent()){
            return question.get();
        }else{
            throw new DataNotFoundException("question not found");

        }
    }
    public void create(String subject, String content, SiteUser user){
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        question.setAuthor(user);
        this.questionRepository.save(question);
    }
    public Page<Question>getList(int page){
        List<Sort.Order>sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));//10개 마다
        return this.questionRepository.findAll(pageable);
    }
    public void modify(Question question, String subject, String content){
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
    public void delete(Question question){
        this.questionRepository.delete(question);
    }
}
