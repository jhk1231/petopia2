package com.example.service.board;

import java.util.ArrayList;

import com.example.vo.board.BoardBoardGradeVO;
import com.example.vo.board.BoardGradeVO;
import com.example.vo.board.BoardVO;

public interface BoardService {
	
	public void registerBoard(BoardVO boardVo, BoardGradeVO boardGradeVo);
	
	public int retrieveConnectArticle(int boardNo);
	
	public void removeBoard(int boardNo);
	
	public void modifyBoard(BoardVO boardVo, BoardGradeVO boardGradeVo);
	
	public BoardBoardGradeVO retrieveOneBoard(int boardNo);
	
	public ArrayList<BoardBoardGradeVO> retrieveAllBoard();
	
	public int retrieveDuplicateBoard(String boardName);
	
	public void registerFavoriteBoard(BoardVO boardVo);
	
	public void removeFavoriteBoard(BoardVO boardVo);
	
	public ArrayList<BoardVO> retrieveFavoriteBoardList(int no);

}
