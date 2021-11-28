package com.example.dao.board;

import java.util.List;

import com.example.vo.board.FileVO;

public interface FileDao {
	List<FileVO> selectFileList(int articleNo);  // 해당 게시글의 파일들 다 불러와
	void insertFile(FileVO fileVO);  // 추가
	void updateFile(FileVO file); // 수정
	// void delete(int FileNo); // 삭제
}
