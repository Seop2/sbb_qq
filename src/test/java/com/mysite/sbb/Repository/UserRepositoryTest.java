package com.mysite.sbb.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    @Test
    public void memberJoin() throws Exception {
        //given

        //when
        
        //then
    }
}