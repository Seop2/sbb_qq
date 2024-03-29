package com.mysite.sbb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter@Setter
public class AnswerForm {
    @NotEmpty(message = "내용을 입력해야합니다.")
    private String content;

}
