package com.uni.boot2.controller;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ThymeTestControllerTest {

    @Test
    void test1(){

        for(int i = 1; i <= 10; i++){ //java7
            System.out.println(i);
        }

        IntStream.range(1,11).forEach(System.out::println); //메소드 참조 : java8에서 추가

        System.out.println("*************************************");

        IntStream.rangeClosed(1,10).forEach(System.out::println); //두번째 인자 포함

        System.out.println("*************************************");

        IntStream.rangeClosed(1,10).forEach(s -> System.out.println(s));
    }

}