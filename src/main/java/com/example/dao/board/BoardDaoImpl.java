package com.example.dao.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.board.BoardMapper;
import com.example.vo.board.BoardBoardGradeVO;
import com.example.vo.board.BoardGradeVO;
import com.example.vo.board.BoardVO;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;

	//게시판 추가
	@Override
	public void insertBoard(BoardVO boardVo) {
		this.boardMapper.insertBoard(boardVo);
		System.out.println(boardVo.toString() + "---------------------Dao insertBoard");
	}

	@Override
	public int selectLastInsertBoardNo() {
		int boardNo = this.boardMapper.selectLastInsertBoardNo();
		return boardNo;
	}

	@Override
	public void insertBoardGrade(BoardGradeVO boardGradeVo) {
		this.boardMapper.insertBoardGrade(boardGradeVo);		
		System.out.println(boardGradeVo.toString() + "---------------------Dao insertBoardGrade");
	}

	
	//연결된 게시글 조회
	@Override
	public int selectConnectArticle(int boardNo) {
		int connectArticle = this.boardMapper.selectConnectArticle(boardNo);
		return connectArticle;
	}

	//게시판 삭제
	@Override
	public void deleteBoard(int boardNo) {
		this.boardMapper.deleteBoard(boardNo);
		
	}

	//게시판 수정
	@Override
	public void updateBoard(BoardVO boardVo, BoardGradeVO boardGradeVo) {
		this.boardMapper.updateBoard(boardVo, boardGradeVo);		
		System.out.println(boardVo.toString() + "-------------dao");
		System.out.println(boardGradeVo.toString() + "-------------dao");
	}

	//게시판 정보 조회
	@Override
	public BoardBoardGradeVO selectOneBoard(int boardNo) {
		BoardBoardGradeVO boardBoardGradeVo = this.boardMapper.selectOneBoard(boardNo);
		return boardBoardGradeVo;
	}
	
	//게시판 정보 조회(전체)
	@Override
	public ArrayList<BoardBoardGradeVO> selectAllBoard() {
		ArrayList<BoardBoardGradeVO> boardAndGradeList = this.boardMapper.selectAllBoard();
		System.out.println("Dao------------------------" + boardAndGradeList.get(5));
		return boardAndGradeList;
	}

	//게시판 이름 중복 검사
	@Override
	public int selectDuplicateBoard(String boardName) {
		int count = this.boardMapper.selectDuplicateBoard(boardName);
		return count;
	}
	
	//즐겨찾기 게시판 추가
	@Override
	public void insertFavoriteBoard(BoardVO boardVo) {
		this.boardMapper.insertFavoriteBoard(boardVo);
		
	}
	
	//즐겨찾기 게시판 삭제
	@Override
	public void deleteFavoriteBoard(BoardVO boardVo) {
		this.boardMapper.deleteFavoriteBoard(boardVo);		
	}

	//즐겨찾기 게시판 조회
	@Override
	public ArrayList<BoardVO> selectFavoriteBoardList(int no) {
		ArrayList<BoardVO> favoriteList = this.boardMapper.selectFavoriteBoardList(no);
		//System.out.println("Dao-------------------" + favoriteList);
		return favoriteList;
	}




}
