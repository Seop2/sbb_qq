package com.mysite.sbb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity//엔티티 인식
@Getter@Setter
//실무에서는 유지보수를 위해 @Setter 사용자제 -> @Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//고유번호 생성
    private Integer id;

    @Column(length = 200)//컬럼의 길이
    private String subject;

    @Column(columnDefinition = "Text")//컬럼 속성
    private String content;

    private LocalDateTime createDate;
//하나의 질문에 여러개의 답변 <연관관계의 주인은 Answer!>
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)//질문을 삭제 시 그에 달린 답변돌도 같이 사라짐
    private List<Answer> answerList;
    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;
//하나의 질문에 여러사람이 추천할 수 있고, 한 사람이 여러 질문에 추천을 할수있다.
    @ManyToMany
    Set<SiteUser>voter;
    //List가 아닌 Set으로 한 이유: 중복되면 안되기 때문 -> 한 사람이 추천을 여러번 할 수없다!
}
