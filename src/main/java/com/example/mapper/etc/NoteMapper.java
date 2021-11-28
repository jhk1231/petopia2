package com.example.mapper.etc;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.etc.NoteVO;

@Mapper
public interface NoteMapper {
	public NoteVO test();
	public ArrayList<NoteVO> selectNoteList(HashMap<String, Object> params);
	public int selectTotalNoteCount(int userNo, int isRecieve);
	public void updateRead_member(int noteNo, int userNo, int isRecieve);
	public void updateRead_counterpart(int noteNo, int userNo, int isRecieve);
	public NoteVO selectNote(int noteNo);
}
