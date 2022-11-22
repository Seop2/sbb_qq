package com.mysite.sbb.Repository;

import com.mysite.sbb.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//리포지토리란?
//엔티티에 의해 생성된 데이터베이스 테이블에 접근하는 메서드들 (findAll..save.....)등을 사용하기 위한 인터페이스이다.
//CRUD 정의
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);

    List<Question>findBySubjectLike(String subject);
}
