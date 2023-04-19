package com.web.community.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor // default 생성자를 만들어줌
@Getter // getter 만드는거 도와줌
@Entity
@Table
public class Board { // class 의 속성이 테이블의 속성이 되도록 만들기!
    @Id // idx 를 기본키로
    @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성할 때 마다 값이 증가함
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column
    private String subTitle;

    @Column
    @Enumerated(EnumType.STRING) // enumType 을 String 형태로
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY) // 미리 로드 시켜서 매칭하는게 아니라 실행할 때 올려서 함
    private User user; // user 랑 board 랑 관계대수 설정 해야함

    @Builder // 생성할 때 값을 주입하고 끝. 나중에 다시 주입하고 그런거 못함. 얘가 그런거 막아줌.
    public Board(String title, String subTitle, BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate, User user) {
        this.title = title;
        this.subTitle = subTitle;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
    }
}
