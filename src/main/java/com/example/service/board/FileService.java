package com.example.service.board;

import java.io.IOException;
import java.util.List;

import com.example.vo.board.ArticleVO;
import com.example.vo.board.FileVO;

public interface FileService {
	
	void uploadFile(ArticleVO article);
	ArticleVO fileList(ArticleVO article, List<FileVO> files);
}
