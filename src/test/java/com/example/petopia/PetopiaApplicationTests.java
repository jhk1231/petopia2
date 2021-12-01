package com.example.petopia;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.board.ArticleMapper;
import com.example.mapper.board.FileMapper;
import com.example.mapper.board.ReplyMapper;
import com.example.mapper.etc.DailyStatisticsMapper;
import com.example.mapper.member.GradeMapper;
import com.example.mapper.member.MemberMapper;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PetopiaApplicationTests {

//	@Autowired
//	private DataSource dataSource;
//	@Autowired
//	private ArticleMapper articleMapper;
//	@Autowired
//	private FileMapper fileMapper;
//	@Autowired
//	private ReplyMapper replyMapper;
//	@Autowired
//	private ReplyService replyService;
//	@Autowired
//	private ArticleService articleService;
//	@Autowired
//	private FileManager fileManager;
//
//
//	private MemberMapper mapper;
//	@Autowired
//	private GradeMapper gradeMapper;
//	
//
//	// @Test
//	// @DisplayName("Mapper 생성 test")
//	// void createTest() {
////		assertNotNull(this.dataSource);
////		assertNotNull(this.articleMapper);
////		assertNotNull(this.fileMapper);
//		// assertNotNull(this.replyMapper);
////		assertNotNull(this.articleService);
////		assertNotNull(this.fileManager);
////	}
}
