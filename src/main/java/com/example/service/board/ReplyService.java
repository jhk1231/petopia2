package com.example.service.board;

import java.util.List;

import com.example.vo.board.ReplyVO;

public interface ReplyService {
	
	List<ReplyVO> retrieveAllReply(int articleNo); //세부 조회
	
	void registerReply(ReplyVO reply); // 추가
	
	void modifyReply(ReplyVO reply); // 수정
	
	void removeReply(int replyNo, int memberNo); // 삭제
	
	void allDelete(int articleNo);
}
