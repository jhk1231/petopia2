package com.example.vo.board;

import java.util.ArrayList;
import java.util.List;

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
@AllArgsConstructor
@RequiredArgsConstructor
@Alias("articleVo")
public class ArticleVO {
	
	private int no; //게시글 번호
	@NonNull private int memberNo; // 회원번호
	@NonNull private int boardNo; // 게시판
	@NonNull private String nickname; // 회원명
	@NonNull private String subject; // 제목
	@NonNull private String content; // 내용
	private String writeDate; // 작성일
	private int viewcount; // 조회수
	private int likecount; // 추천수
	private int articleGroup; // 게시글 그룹
	private int groupNum; // 그룹에서의 순서
	private int dept; // 원글과의 거리
	private int displayNotice; // 공지 보여지는 여부
	private FileVO attacheFile; //첨부 파일
	private FileVO thumbnail; // 썸네일
	private List<FileVO> fileList = new ArrayList<>(); // 이미지 List
	private List<ReplyVO> replyList = new ArrayList<>(); // 댓글
}
