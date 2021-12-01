package com.example.vo.board;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("selectArticleVo")
public class SelectArticleVO {
	
	private ArticleVO article;
	private FileVO file;
}
