package com.uni.boot2.repository;

import com.uni.boot2.domain.Board;
import com.uni.boot2.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@Transactional
//@SpringBootTest //스프링부트 어플리케이션 테스트에 필요한 모든 데이터를 제공해줌 (의존성도 가능)
//@Rollback(value = false)
@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository; //BoardRepository에 있는 메소드들을 사용하기 위한 의존성 추가

    @Test
    void insertBoard(){
        //given : 어떤 값이 주어졌을 때

        String title = "test";
        String content = "boardContent";
        String writer = "user11";
        Board params = Board.builder() //build메소드를 사용해 Entity형태로 넣어줌 (원하는 값을 넣었음), Board는 엔티티, params는 엔티티 객체
                .boardTitle(title)
                .boardContent(content)
                .boardWriter(writer)
                .build();



        //when : 어떤 시점 또는 어떤 동작이 돌아갔을 때
        boardRepository.save(params);

        //then : 어떤 값(기대하는 값)이 들어갔는지 검증하는 단계
        List<Board> list = boardRepository.findAll();
        Board board = list.get(0);

        //어썰트 제이에서 제ㅐ공하는 assert 어썰트제이 문법으로 사용해야 함
        assertThat(board.getBoardTitle()).as("값을 확인해 주세요. 현재값 : %s",board.getBoardTitle()).isEqualTo(title);//isEqualTo가 false면 as()가 실행
        assertThat(board.getBoardContent()).as("값을 확인해 주세요. 현재값 : %s",board.getBoardContent()).isEqualTo(content);
    }


    @Test
    void selectBoardAll(){
        List<BoardDto> list = IntStream.rangeClosed(1,9).asLongStream().mapToObj(i->{

            BoardDto dto = BoardDto.builder()
                    .boardTitle("언어의 온도"+i)
                    .boardWriter("작성자"+i)
                    .boardContent("무슨내용"+i)
                    .build();
            return dto;

        }).collect(Collectors.toList()); //given

        for(BoardDto board : list){
            boardRepository.save(board.toEntity()); //save메소드, findAll메소드는 엔티티만 들어갈 수 있음 때문에 Entity화해서 넣어야 한다. (toEntity메소드 사용)
        }

        Long boardCount = boardRepository.count();

        System.out.println("총갯수 --------"+ boardCount);


        List<Board> boards = boardRepository.findAll(); //오름차순이 기본값

        List<Board> boards1 = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id")); //내림차순 지정

        boards.stream().forEach(board -> { //stream 데이터 타입별로 써야하는 메소드가 다름. -> 데이터타입을 스트림화하면 데이터 타입을 알아서 찾아가게 해준다. 그래서 forEach 사용이 가능 (속도가 느림)
            System.out.println("board --------"+board.getId());
        });

        boards1.stream().forEach(board -> {
            System.out.println("board1 --------"+board.getId());
        });
    }

    @Test
    void deleteBoard(){

        Optional<Board> entity = boardRepository.findById((long) 1);
        entity.ifPresent(selectedBoard -> {
            boardRepository.delete(selectedBoard);
        });

//        Board entity1 = boardRepository.findById((long) 2).get();
//        boardRepository.delete(entity1);

//        boardRepository.deleteById(6L);
    }
}