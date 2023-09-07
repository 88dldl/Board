package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired // 스프링빈이 알아서 읽어와서 주입해줌
    private BoardRepository boardRepository; // 객체 생성안됨,

    // 글 작성 처리
    public  void write(Board board){
        boardRepository.save(board);
    }

    //게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable){

        return boardRepository.findAll(pageable);
    }
    // 특정게시글 찾기
    public Page<Board> boardSearchList(String searchKeyword,Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyword,pageable);
    }

    // 특정게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get(); //findbyid하면 optional값으로 받아오기때문에 get()을 써줘야함
    }

    // 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
