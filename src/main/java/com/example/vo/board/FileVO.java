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
@AllArgsConstructor
@RequiredArgsConstructor
@Alias("fileVo")
public class FileVO {
	private int no;
	@NonNull private int articleNo;
	@NonNull private String originalFileName; // 유저가 올린 진짜 파일 이름
	@NonNull private String systemFileName; // 서버에서 관리될 파일 이름
	@NonNull private Long fileSize;
	@NonNull private int fileType; // 0이면 첨부, 1이면 이미지
	
	public FileVO(@NonNull String originalFileName, @NonNull String systemFileName, @NonNull Long fileSize) {
		this.originalFileName = originalFileName;
		this.systemFileName = systemFileName;
		this.fileSize = fileSize;
	}
 	
	
}
