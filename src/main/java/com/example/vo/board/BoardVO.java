package com.example.vo.board;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("boardVO")
public class BoardVO {
   public BoardVO(int i, String string) {
		// TODO Auto-generated constructor stub
	}
private int categoryNo;
   private int boardNo;
   private String boardName;
   private int boardkind; //게시판종류  / TINYINT / NotNull, default 0
   
   private int favoriateNo;
   private int no;
   
   
   
}

