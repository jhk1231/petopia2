package com.example.vo.board;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Alias("likeVo")
public class LikeVO {
	private int no;
	@NonNull private int memberNo;
	@NonNull private int articleNo;

}
