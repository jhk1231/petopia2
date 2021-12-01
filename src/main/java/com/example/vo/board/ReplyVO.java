package com.example.vo.board;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Alias("replyVo")
public class ReplyVO {
	private int no;
	@NonNull private int articleNo;
	@NonNull private int memberNo;
	@NonNull private String nickname;
	private String writeDate;
	@NonNull private String content;
	
	public ReplyVO(int no, @NonNull String content) {
		super();
		this.no = no;
		this.content = content;
	}
	
	
}
