package com.uni.boot2.controller;


import com.uni.boot2.dto.ThymeTestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/thyme")
@Slf4j //log
@Controller
public class ThymeTestController {

    @GetMapping("/")
    public String test1(){
        return "thyme/thymeleaf1";
    }

    @GetMapping("/test2")
    public String test2(Model model){

        List< ThymeTestDto> list = IntStream.rangeClosed(1,9).asLongStream().mapToObj(i -> {
            ThymeTestDto dto = ThymeTestDto.builder()
                    .id(i)
                    .name("유재석"+i)
                    .phone("010-9999-123"+i)
                    .createDate(LocalDateTime.now())
                    .build();
            return dto;
        }).collect(Collectors.toList()); //앞에서 만든 객체를 toList형태로 만든다.

        model.addAttribute("lists",list);
        log.info(String.valueOf(list));

        return "thyme/thymeleaf1";
    }
}
