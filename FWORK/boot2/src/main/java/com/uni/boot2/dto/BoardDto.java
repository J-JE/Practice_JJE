package com.uni.boot2.dto;


import com.uni.boot2.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //전체 생성자
public class BoardDto {

    private long id;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String status;
    private LocalDateTime createDate;


    public Board toEntity(){
        Board board = Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardWriter(boardWriter)
                .build();
        return board;
    }
}
