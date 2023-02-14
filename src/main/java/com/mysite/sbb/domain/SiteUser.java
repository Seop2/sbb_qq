package com.mysite.sbb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)//유일한 값만 저장 : 값을 중복되게 저장할수 없음
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
}
