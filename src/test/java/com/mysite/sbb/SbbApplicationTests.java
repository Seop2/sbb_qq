package com.mysite.sbb;

import com.mysite.sbb.Repository.QuestionRepository;
import com.mysite.sbb.domain.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {
	@Autowired//스프링의 DI(dependency Injection) 기능 - 리포지토리 객체를 생성하여 주입
	//Autowired 보다는 생성자릁 통한 객체 주입 방식 권장
	//테스트 코드의 경우 생성자를 통한 주입이 불가능 하므로 테스트 코드 작성시에만 @Autowired 를 사용
	private QuestionRepository questionRepository;
	@Test
	void contextLoads() {
	}
	//@Transactional//메서드가 종료될 때 자동으로 롤백(db에 데이터 안남음)
	@Test
	public void 질문답변() throws Exception {
	    //given
	    Question q1 = new Question();
		q1.setSubject("스프링이란 뭘까요?");
		q1.setContent("스프링이랑 스프링부트의 차이에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);//첫번째 질문 저장
		Question q2 = new Question();
		q2.setSubject("jpa이란 뭘까요?");
		q2.setContent("jpa랑 mybatis의 차이에 대해서 알고 싶습니다.");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);//두번째 질문 저장
	    //when

	    //then
	}
	@Test
	public void 데이터조회() throws Exception {

	    //given
		List<Question> all = this.questionRepository.findAll();//데이터 조회
		assertEquals(2,all.size());//(기대값, 실제값) -> 동일하지 않을 시 실패 처리
	    //when
	    Question q = all.get(0);
		assertEquals("스프링이란 뭘까요?", q.getSubject());//subject값 비교
	    //then
	}

	@Test
	public void 데이터id조회() throws Exception {
	    //given
		Optional<Question>oq = this.questionRepository.findById(2);//id값으로 조회 - 리턴타입: Optional(null 처리)
		if(oq.isPresent()){//null인지 아닌지 확인
			Question q = oq.get();
			assertEquals("jpa란 뭘까요?", q.getSubject());
		}
	    //when

	    //then
	}

}
