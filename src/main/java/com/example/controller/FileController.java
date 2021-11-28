package com.example.controller;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;

import com.example.dao.board.FileDao;
import com.example.util.FileManager;
import com.example.vo.board.FileVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FileController {

	private final FileManager fileManager;
	private final FileDao fileDao;
	
	// 이미지 다운로드
	@ResponseBody
	@GetMapping("/images/{filename}")
	public Resource downLoadImage(@PathVariable String filename) throws MalformedURLException{
		return new UrlResource("file:" + fileManager.getFullPath(filename));
	}

	// 첨부파일 다운로드
	@GetMapping("/attach/{fileNo}")
	public ResponseEntity<Resource> downloadAttach(@PathVariable int fileNo) throws MalformedURLException{
		FileVO file = this.fileDao.selectFile(fileNo);
		String systemFileName = file.getSystemFileName();
		String originalFileName = file.getOriginalFileName();
		
		UrlResource resource = new UrlResource("file:" + fileManager.getFullPath(systemFileName));
		
		log.info("originFileName= {}",originalFileName);
		
		String encodedUploadFileName = UriUtils.encode(originalFileName, StandardCharsets.UTF_8);
		String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
				.body(resource);
	}
	
}
