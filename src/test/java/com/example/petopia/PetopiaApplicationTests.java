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

import com.e

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PetopiaApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private FileMapper fileMapper;
	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private FileManager fileManager;


	private MemberMapper mapper;
	@Autowired
	private GradeMapper gradeMapper;
	

	// @Test
	// @DisplayName("Mapper 생성 test")
	// void createTest() {
//		assertNotNull(this.dataSource);
//		assertNotNull(this.articleMapper);
//		assertNotNull(this.fileMapper);
		// assertNotNull(this.replyMapper);
//		assertNotNull(this.articleService);
//		assertNotNull(this.fileManager);
//	}
//	@Test
//	void tt() {
//		this.replyService.removeReply(65);
//		
//	}
//	@Test
//	void replyTest() {
//		List<ReplyVO> re = this.replyService.retrieveAllReply(2);
//		for (ReplyVO replyVO : re) {
//			log.info(replyVO.toString());
//			
//		}
//	}

//	@Test
//	@DisplayName("insert Test")
//	void insertTest() {
//		ArticleVO aritce = new ArticleVO(1, 5, "일일일", "testtest", "testetst");
//		this.articleService.registerArticle(aritce);
//	}

//	@Test
//	void test2() { 
//		ArticleVO art = new ArticleVO(1,2,"ddd","삭제해", "내용");
//		this.articleMapper.insertArticle(art);
//		System.out.println("***no****:" + art.getNo());
//	}

//	@Test
//	@DisplayName("목록 조회 test")
//	void test3() {
//		List<ArticleVO> articles = this.articleService.retrieveBoard(5);
//		articles.forEach(article -> log.info(article.toString()));
//	}

//	@Test
//	@DisplayName("세부조회 Test ver.1")
//	void test4() {
//		ArticleVO article = this.articleMapper.selectArticle(10);
//		log.info(article.toString());
//	}

//	@Test
//	void insertFile() {
//		ArticleVO article = new ArticleVO(1, 2, "일일일", "파첨테테", "파첨테");
//		List<FileVO> fList = new ArrayList<FileVO>();
//		fList.add(new FileVO(1, "테스트입니다55", "test333", 1132335L));
//		fList.add(new FileVO(3, "테스트입니다5555", "test444", 135L));
//		article.setFileList(fList);
//		this.articleService.registerArticle(article);
//	}

//	@Test
//	void selectFile() {
//		FileVO fie = this.fileMapper.selectFile(2);
//		log.info("파일 찍기={}", fie.toString());
//	}

//	@Test
//	void select() {
//		List<SelectArticleVO> select = this.articleMapper.selectArticle(91);
//		for (SelectArticleVO selectArticleVO : select) {
//			log.info(selectArticleVO.getArticle().toString());
//		}
//		log.info("***************" + select.get(0).getArticle());
//	}

//	@Test
//	void te() {
//		FileVO ff = new FileVO();
//		ff.setArticleNo(5);
//		ff.setFileType(0);
//		List<FileVO> fi = this.fileMapper.selectThumbFile(ff);
//		for (FileVO fileVO : fi) {
//			log.info(fileVO.toString());
//			
//		}
//	}

//	@Test
//	void tt() {
//		Map<String, String> map = new HashMap<>();
//		List<ReplyVO> replys = new ArrayList<>();
//		ReplyVO re = new ReplyVO(1, 2, "sd", "asdasd");
//		ReplyVO re1 = new ReplyVO(1, 2, "sdd", "asdasddsa");
//		ReplyVO re2 = new ReplyVO(1, 2, "sdd", "dasdasd");
//		ReplyVO re3 = new ReplyVO(1, 2, "sddd", "asddasd");
//		replys.add(re3);
//		replys.add(re);
//		replys.add(re1);
//		replys.add(re2);
//		replys.add(re3);
//		List<Map<String, String>> rsList = new ArrayList<>();
//		JSONArray json = new JSONArray();
//		for (ReplyVO reply : replys) {
//			JSONObject jsonobj = new JSONObject();
//			jsonobj.put("articleNo", reply.getArticleNo());
//			jsonobj.put("memberNo", reply.getMemberNo());
//			jsonobj.put("nickname", reply.getNickname());
//			jsonobj.put("content", reply.getContent());
//			json.put(jsonobj);
//		}
//		for (ReplyVO reply : replys) {
//			JSONObject jsonobj = new JSONObject();
//			jsonobj.add("articleNo", reply.getArticleNo());
//			jsonobj.put("memberNo", reply.getMemberNo());
//			jsonobj.put("nickname", reply.getNickname());
//			jsonobj.put("content", reply.getContent());
//			json.put(jsonobj);
//		}
//		log.info(json.toString());
//	}

//	@Autowired
//	private DailyStatisticsMapper dailyMapper;

/*
 * @Test void mappertest() {
 * //System.out.println(service.login("admin@naver.com", "1111")); try {
 * System.out.println(mapper.selectMember_byIDPwd("123@naver.com", "1234")); }
 * catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
 * } }
 */

/*
 * @Test void mappertest1() {
 * //System.out.println(service.login("admin@naver.com", "1111"));
 * 
 * try { DailyStatisticsVO dailyVo = dailyMapper.selectDaily(2);
 * dailyVo.setDailyDate((dailyVo.getDailyDate().split(" ")[0]));
 * System.out.println(dailyVo); } catch (Exception e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } }
 */
/*
 * @Test void mappertest1() { //
 * System.out.println(service.login("admin@naver.com", "1111"));
 * 
 * ArrayList<DailyStatisticsVO> dailyVo = dailyMapper.selectList(); for
 * (DailyStatisticsVO dailyStatisticsVO : dailyVo) {
 * dailyStatisticsVO.setDailyDate((dailyStatisticsVO.getDailyDate().split(" ")[0
 * ]));
 * 
 * } System.out.println(dailyVo); }
 */
}
