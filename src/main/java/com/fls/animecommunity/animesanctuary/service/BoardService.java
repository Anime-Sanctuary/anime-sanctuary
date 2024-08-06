package com.fls.animecommunity.animesanctuary.service;

import com.fls.animecommunity.animesanctuary.model.board.Board;
import com.fls.animecommunity.animesanctuary.model.board.dto.BoardRequestsDto;
import com.fls.animecommunity.animesanctuary.model.board.dto.BoardResponseDto;
import com.fls.animecommunity.animesanctuary.model.board.dto.SuccessResponseDto;
import com.fls.animecommunity.animesanctuary.repository.BoardRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //list
    @Transactional(readOnly = true)
    public List<BoardResponseDto> getPosts() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }
    
    //find
    @Transactional
    public BoardResponseDto getPost(Long id) {
    	return boardRepository.findById(id).map(BoardResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }
    
    //write
    @Transactional
    public BoardResponseDto createPost(BoardRequestsDto requestsDto) {
        Board board = new Board(requestsDto);
        boardRepository.save(board);
    	
    	return new BoardResponseDto(board);
    }
    
    //update
    @Transactional
    public BoardResponseDto updatePost(Long id, BoardRequestsDto requestsDto) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!requestsDto.getPassword().equals(board.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다.");

        board.update(requestsDto);
        return new BoardResponseDto(board);
    }
    
    //delete
    @Transactional
    public SuccessResponseDto deletePost(Long id, BoardRequestsDto requestsDto) throws Exception{
    	Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if (!requestsDto.getPassword().equals(board.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다.");

        boardRepository.deleteById(id);
        return new SuccessResponseDto(true);
    }
}
