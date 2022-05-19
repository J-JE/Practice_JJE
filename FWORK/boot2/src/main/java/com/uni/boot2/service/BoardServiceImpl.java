package com.uni.boot2.service;

import com.uni.boot2.domain.Board;
import com.uni.boot2.dto.BoardDto;
import com.uni.boot2.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository; //@Autowired사용도 가능

    public BoardServiceImpl(BoardRepository boardRepository){ //생성자로 주입으로 의존성 (한번만 주입되면 됨 : final)
        this.boardRepository = boardRepository;
    }

    @Override
    public List<BoardDto> selectBoardAll() {

        List<Board> boards = boardRepository.findAll();

        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boards){
            BoardDto dto = BoardDto.builder()
                    .id(board.getId())
                    .boardTitle(board.getBoardTitle())
                    .boardContent(board.getBoardContent())
                    .boardWriter(board.getBoardWriter())
                    .createDate(board.getCreateDate())
                    .build();

            boardDtoList.add(dto);
        }

        return boardDtoList;
    }

    @Override
    public void insertBoard(BoardDto board) {

        boardRepository.save(board.toEntity());
    }

    @Override
    public void deleteById(long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Object selectBoard(long id) {
        Optional<Board> entity = boardRepository.findById(id);

        if(entity.isPresent()){ //isPresent : boolean값으로 넘어옴 if와 다르게 자동으로 다른건 안해줌
            Board board = entity.get();

            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .boardTitle(board.getBoardTitle())
                    .boardContent(board.getBoardContent())
                    .boardWriter(board.getBoardWriter())
                    .createDate(board.getCreateDate())
                    .build();

            return boardDto;
        }

        return null;
    }

    @Override
    public void updateBoard(BoardDto board) {

        Optional<Board> entity = boardRepository.findById((long) board.getId());
        /*
        만약 수정하러 들어오면 id나 이런걸로 새로 대상을 조회해와서 체크를하고 태워야한다 강조하는 회사도 많으니
        기능을 태우면 일단 먼저 데이터가 있는지 없는지 체크를 하고 데이터를 태우는게 좋음
        */
        if(entity.isPresent()){
            Board b = entity.get();

//            b.changeTitle(board.getBoardTitle());
//            b.changeContent(board.getBoardContent());
//            b.changeWriter(board.getBoardWriter());

            b.changeBoard(board.getBoardTitle(), board.getBoardContent(), board.getBoardWriter());
            boardRepository.save(b);
        }
    }
}
