package com.example.dao.etc;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.etc.NoteMapper;
import com.example.vo.etc.NoteVO;

@Repository("noteDao")
public class NoteDaoImpl implements NoteDao {
	@Autowired
	private NoteMapper mapper;
	
	@Override
	public NoteVO test() {
		// TODO Auto-generated method stub
		return mapper.test();
	}

	@Override
	public ArrayList<NoteVO> selectNoteList(int userNo, int isUserReciever, int pageSize, int startOffset) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("userNo", userNo);
		map.put("isUserReciever", isUserReciever);
		map.put("pageSize", pageSize);
		map.put("startOffset", startOffset);
		
		return mapper.selectNoteList(map);
	}

	@Override
	public int selectTotalNoteCount(int userNo, int isRecieve) {
		// TODO Auto-generated method stub
		return mapper.selectTotalNoteCount(userNo, isRecieve);
	}

	@Override
	public void updateRead(int noteNo, int userNo) {
		mapper.updateRead_member(noteNo, userNo, 1);
		mapper.updateRead_counterpart(noteNo, userNo, 0);
	}

	@Override
	public NoteVO selectNote(int noteNo) {
		// TODO Auto-generated method stub
		return mapper.selectNote(noteNo);
	}

}
