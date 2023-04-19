package com.web.community.domain;

import com.web.community.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

// Board 랑 User 만든거 잘 만들어졌는지(DB에 잘 들어갔는지) 확인하고 싶어~
@DataJpaTest
class BoardTest {
//    private final String boardTestTtile="This is Test!!";
    private final String email = "test@gmail.com";

    @Autowired //
    UserRepository userRepository;

    @BeforeEach // 실행 전에 데이터를 만들어서 저장을 시켜보는거야~
    public void Initialize() {
        // user 를 만들어서 DB 에 저장하기
        User user = userRepository.save(User.builder()
                .name("Lee")
                .password("123")
                .email(email)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build()
        );
    }
    @Test
    public void saveCheck() { // 저장 잘됬나 확인~
        // 1. email 로 데이터를 찾아옴
        User user = userRepository.findByEmail(email);

        // 2. 데이터를 비교하여 찾아온 데이터가 맞는지 확인함
        Assertions.assertEquals(user.getEmail(), email); // 앞에거랑 뒤에꺼랑 비교해서 결과반환하는 메소드임
        Assertions.assertEquals(user.getName(), "Lee");
    }
}