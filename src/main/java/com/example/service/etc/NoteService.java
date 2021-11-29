package com.example.service.etc;

import java.util.ArrayList;

import com.example.vo.etc.NoteVO;
import com.example.vo.member.MemberVO;

public interface NoteService {
	public NoteVO test();
	public ArrayList<NoteVO> selectNoteList(int userNo, int isUserReciever, int pageSize, int startOffset);
	public int retriveTotalNoteCount(int userNo, int isRecieve);
	public void updateRead(int noteNo, int userNo);
	public NoteVO retriveNote(int noteNo);
	public boolean registerNote(NoteVO note, MemberVO user);
	public void removeNote(ArrayList<NoteVO> notelist, int isRecieve);
	
}
