package com.mysite.sbb.service;

import com.mysite.sbb.Repository.UserRepository;
import com.mysite.sbb.domain.SiteUser;
import com.mysite.sbb.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public SiteUser create(String username, String email, String password){
        SiteUser user = new SiteUser();
        user.setUsername(username);
//        user.setPassword(password);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));//빈으로 등록한 패스워드 암호화객체를 저장
        this.userRepository.save(user);
        return user;
    }
    public SiteUser getUser(String username){
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if (siteUser.isPresent()){
            return siteUser.get();
        }else {
            throw new DataNotFoundException("siteUser not found");
        }
    }

}
