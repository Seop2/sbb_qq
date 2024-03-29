package com.mysite.sbb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter@Setter
public class UserCreateForm {
    @Size(min=3, max = 25)
    @NotEmpty
    private String username;
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;
    @NotEmpty(message = "비밀번호확인은 팔수입니다.")
    private String password2;
    @NotEmpty(message = "이메일은 필수항목!")
    @Email
    private String email;
}
