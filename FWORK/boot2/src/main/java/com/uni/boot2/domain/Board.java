package com.uni.boot2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder //생성자 없이도 생성가능하게
@AllArgsConstructor //모두 들어있는 생성자
@NoArgsConstructor //기본 생성자
@Getter //Setter는 안됨
@Entity //엔티티 선언
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //레파지토리 기본으로 만드는 id타입이 long

    @Column
    private String boardTitle;

    @Column
    private String boardContent;

    @Column
    private String boardWriter;

    @Column
    private String status;


    public void changeTitle(String title){ this.boardTitle = title;}
    public void changeContent(String content){ this.boardContent = content;}
    public void changeWriter(String writer){ this.boardWriter = writer;}

    public void changeBoard(String title, String content, String writer){
        this.boardTitle = title;
        this.boardContent = content;
        this.boardWriter = writer;
    }

}
