package com.uni.boot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Slf4j //log
@Controller
public class BoardController {
    //dto는 계층간의 데이터를 교환하고 이동할때 사용

        //요런식으로
       /*  List<ThymeTestDto> list = IntStream.rangeClosed(1, 9).asLongStream().mapToObj(i->{ //asLongStream() dto에서 long타입으로 써놔서 형변환을 시킬려고 작성
                ThymeTestDto dto = ThymeTestDto.builder() // builder() : 자기가원하는것만으로 객체 생성
                        .id(i)
                        .name("유재석" + i)
                        .phone("010-9999-123" + i)
                        .createDate(LocalDateTime.now())
                        .build(); //객체를 생성
                return dto; */

        /* ORM이란 : 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것을 말한다. ( Object Relational Mapping, 객체-관계 매핑 )

                    객체 지향 프로그래밍은 클래스를 사용하고, 관계형 데이터베이스는 테이블을 사용한다.
                    객체 모델과 관계형 모델 간에 불일치가 존재한다.
                    ORM을 통해 객체 간의 관계를 바탕으로 SQL을 자동으로 생성하여 불일치를 해결한다.
                    데이터베이스 데이터 <—매핑—> Object 필드
                    객체를 통해 간접적으로 데이터베이스 데이터를 다룬다.
                    Persistant API라고도 할 수 있다.
                    Ex) JPA, Hibernate 등  <https://gmlwjd9405.github.io/2019/02/01/orm.html> */

    // ORM을 구현하면서 기존 mybatis가 아닌 "hibernate"를 사용하며 jpa를 대표적으로 구현한 구현체임
    @GetMapping()
    public String main(){
        return "redirect:/board/boardListView";
    }

    @GetMapping("/boardListView")
    public void selectBoardAll(){

    }
}
