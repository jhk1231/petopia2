package com.example.service.etc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.etc.NoteDao;
import com.example.vo.etc.NoteVO;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDao dao;
	
	@Override
	public NoteVO test() {
		// TODO Auto-generated method stub
		return dao.test();
	}

	@Override
	public ArrayList<NoteVO> selectNoteList(int userNo, int isUserReciever, int pageSize, int startOffset) {
		// TODO Auto-generated method stub
		return dao.selectNoteList(userNo, isUserReciever, pageSize, startOffset);
	}

	@Override
	public int retriveTotalNoteCount(int userNo, int isRecieve) {
		// TODO Auto-generated method stub
		return dao.selectTotalNoteCount(userNo, isRecieve);
	}

	@Override
	public void updateRead(int noteNo, int userNo) {
		dao.updateRead(noteNo, userNo);
	}

	@Override
	public NoteVO retriveNote(int noteNo) {
		// TODO Auto-generated method stub
		return dao.selectNote(noteNo);
	}
	
}
