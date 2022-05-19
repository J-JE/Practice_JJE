package com.uni.boot2.controller;

import com.uni.boot2.dto.BoardDto;
import com.uni.boot2.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc // Mock : 테스트를 위해서 만들어진 모형, 실제로 있는걸 사용X, 모의객체를 만드는 것 Mock, Mocking해서 사용하는 것 Mock Up
@SpringBootTest //
class BoardControllerTest {

    /*
      Mock
    - Mock이라는 단어를 사전에서 찾아보면 '테스트를 위해 만든 모형'을 의미한다.
    - 테스트를 위해 실제 객체와 비슷한 모의 객체를 만드는 것을 모킹(Mocking)이라고 하며, 모킹한 객체를 메모리에서 얻어내는 과정을 목업(Mock-up)이라고 한다.

      테스트 하려는 실제 객체와 비슷한 가짜 객체를 만들어서 테스트에 필요한 기능만 가지도록 모킹을 하면 테스트가 쉬워진다.

      테스트하려는 객체가 복잡한 의존성을 가지고 있을 때, 모킹한 객체를 이용하면, 의존성을 단절시킬 수 있어서 쉽게 테스트할 수 있다.

      웹 애플리케이션에서 컨트롤러를 테스트할 때, 서블릿 컨테이너를 모킹하기 위해서는 @WebMvcTest를 사용하거나 @AutoConfigureMockMvc를 사용하면 된다.
     */
    
    @Autowired
    MockMvc mvc;

    @Mock
    BoardRepository boardRepository;

    @Test //한글 메소드명 가능 (DisplayName이 우선순위가 높다.)
//    @DisplayName("메인이동_확인") //한글 사용 가능, 어떤걸 테스트 했는지
    void main() throws Exception {
        //MockMvc를 사용해어떤 주소로 요청할것인지 (컨트롤러에서는 해단 링크로 잘 들어오고 나가는지)
        mvc.perform(get("/")) //url의 결과를 검증하겠다
                .andExpect(status().isOk()) //정상적으로 수행됐는지 확인, isOk : 응답상태 코드가 정상인지(200번대인지)
                .andExpect(forwardedUrl("index.html")) //인덱스화면에서 요청
                .andDo(print());
    }

    @Test
    @DisplayName("조회, 전체조회")
    void selectBoardAll() throws Exception {
        mvc.perform(get("/board/boardListView"))
                .andExpect(status().isOk())
//                .andExpect(forwardedUrl("index.html")) // ?
                .andDo(print());
    }

    @Test
    @DisplayName("삭제, 회원정보 삭제")
    void deleteBoard() throws Exception {
        BoardDto dto = BoardDto.builder() // 테스트를 위헤 값을 임시로 넣어주기
                .boardTitle("언어의 온도")
                .boardWriter("작성자")
                .boardContent("무슨내용")
                .build();
        boardRepository.save(dto.toEntity());

        mvc.perform(get("/board/delete/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/boardListView"))
                .andDo(print());
        /*
        300	Multiple Choices (사용자측에서 마음대로 선택, 선택방법은 표준없음)
        301	Moved permanently (완전히 주소변경된 경우)
        302	Not temporarily (임시적으로 주소변경된 경우)
        304	Not modified (컴퓨터 로컬의 캐시 정보를 이용함, 대개 gif 등은 웹 서버에 요청하지 않음)

        https://hi098123.tistory.com/200

        */
    }

}