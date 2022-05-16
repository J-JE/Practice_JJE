package com.uni.boot2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder //객체의 일부 값마으로 생성자 사용 가능
public class ThymeTestDto {//https://projectlombok.org/features/Builder

    private long id;

    private String name;

    private String phone;

    private LocalDateTime createDate;
}
