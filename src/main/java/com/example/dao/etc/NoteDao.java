package com.example.dao.etc;

import java.util.ArrayList;
import java.util.Map;

import com.example.vo.etc.NoteVO;

public interface NoteDao {
	public NoteVO test();
	public ArrayList<NoteVO> selectNoteList(int userNo, int isUserReciever, int pageSize, int startOffset);
	public int selectTotalNoteCount(int userNo, int isRecieve);
	public void updateRead(int noteNo, int userNo);
	public NoteVO selectNote(int noteNo);

	// 쪽지 insert
	public int insertNoteContent(String content) throws Exception;
	public void insertNote_member(Map<String, Object> map) throws Exception;
	public void insertNote_counterpart(Map<String, Object> map) throws Exception;
}
