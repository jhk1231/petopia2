package com.example.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.board.BoardDao;
import com.example.vo.board.BoardBoardGradeVO;
import com.example.vo.board.BoardGradeVO;
import com.example.vo.board.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	// 게시판 추가(기본정보 + 등급)
	@Override
	@Transactional
	public void registerBoard(BoardVO boardVo, BoardGradeVO boardGradeVo) {
		this.boardDao.insertBoard(boardVo);
		boardGradeVo.setBoardNo(this.boardDao.selectLastInsertBoardNo());
		this.boardDao.insertBoardGrade(boardGradeVo);
	}

	// 게시판 종류 조회
	@Override
	public List<BoardVO> retrieveBoardkind() {
		List<BoardVO> boardkindList = this.boardDao.selectBoardkind();
		return boardkindList;
	}

	// 연결된 게시글 조회
	@Override
	public int retrieveConnectArticle(int boardNo) {
		int connectArticle = this.boardDao.selectConnectArticle(boardNo);
		return connectArticle;
	}

	// 게시판 삭제
	@Override
	public void removeBoard(int boardNo) {
		this.boardDao.deleteBoard(boardNo);

	}

	// 게시판 수정
	@Override
	public void modifyBoard(BoardVO boardVo, BoardGradeVO boardGradeVo) {
		this.boardDao.updateBoard(boardVo, boardGradeVo);
		System.out.println(boardVo.toString() + "-------------service");
		System.out.println(boardGradeVo.toString() + "-------------service");
	}

	// 게시판 정보 조회
	@Override
	public BoardBoardGradeVO retrieveOneBoard(int boardNo) {
		BoardBoardGradeVO boardGradeVo = this.boardDao.selectOneBoard(boardNo);
		return boardGradeVo;
	}

	// 게시판 정보 조회 (전체)
	@Override
	public ArrayList<BoardBoardGradeVO> retrieveAllBoard() {
		ArrayList<BoardBoardGradeVO> boardAndGradeList = this.boardDao.selectAllBoard();
		return boardAndGradeList;
	}

	@Override
	public List<BoardVO> retrieveAllWriteBoard(int gradeNo) {
		ArrayList<BoardBoardGradeVO> boardAndGradeList = this.boardDao.selectAllBoard();
		List<BoardBoardGradeVO> writeBoardList = new ArrayList<>();
		List<BoardVO> resultBoardList = new ArrayList<>();
		for (BoardBoardGradeVO bbg : boardAndGradeList) {
			// 쓰기 등급 List 가져오기
			if (bbg.getBoardGradeVo().getReadwrite() == 0) {
				writeBoardList.add(bbg);
//				log.info("wrteList: " + bbg.toString());
			}
		}
		for (BoardBoardGradeVO write : writeBoardList) {
			if (write.getBoardGradeVo().getGradeNo() >= gradeNo) {
				resultBoardList.add(write.getBoardVo());
//				log.info("**Result**" + write.toString());
			}
		}
		return resultBoardList;
	}

	@Override
	public boolean retrieveAllReadBoard(int boardNo, int gradeNo) {
		BoardBoardGradeVO bbgVO = this.boardDao.selectOneBoard(boardNo);
		if (bbgVO.getBoardGradeVo().getReadGrade() >= gradeNo) {
			return true;
		} else {
			return false;
		}

	}

//	//게시판 중복 검사
//	@Override
//	public int retrieveDuplicateBoard(String boardName) {
//		int count = this.boardDao.selectDuplicateBoard(boardName);
//		return count;
//	}
//
//	//즐겨찾기 게시판 추가
//	@Override
//	public void registerFavoriteBoard(BoardVO boardVo) {
//		this.boardDao.insertFavoriteBoard(boardVo);
//	}
//
//	//즐겨찾기 게시판 삭제
//	@Override
//	public void removeFavoriteBoard(BoardVO boardVo) {
//		this.boardDao.deleteFavoriteBoard(boardVo);
//	}
//
//	//즐겨찾기 게시판 조회
//	@Override
//	public ArrayList<BoardVO> retrieveFavoriteBoardList(int no) {
//		ArrayList<BoardVO> favoriteList = this.boardDao.selectFavoriteBoardList(no);
//		return favoriteList;
//	}
}
