package com.example.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.board.ReplyDao;
import com.example.vo.board.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public List<ReplyVO> retrieveAllReply(int articleNo) {
		return this.replyDao.selectAllReply(articleNo);
	}

	@Override
	public void registerReply(ReplyVO reply) {
		this.replyDao.insertReply(reply);
	}

	@Override
	public void modifyReply(ReplyVO reply) {
		this.replyDao.updateReply(reply);
	}

	@Override
	public void removeReply(int replyNo) {
		this.replyDao.deleteReply(replyNo);
	}
	
	@Override
	public void allDelete(int articleNo) {
		this.replyDao.allDelete(articleNo);
		
	}

}
