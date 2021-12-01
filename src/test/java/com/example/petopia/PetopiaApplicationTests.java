package com.example.petopia;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.mapper.member.GradeMapper;
import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;

import com.example.mapper.etc.DailyStatisticsMapper;
import com.example.vo.etc.DailyStatisticsVO;


@SpringBootTest
class PetopiaApplicationTests {

//	@Autowired
//	private MemberService service;
	@Autowired
	private MemberMapper mapper;
	@Autowired
	private GradeMapper gradeMapper;
	
	@Test
	void mappertest() {
		//System.out.println(service.login("admin@naver.com", "1111"));
		try {
			System.out.println(mapper.selectMember_byIDPwd("123@naver.com", "1234"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Autowired
	private DailyStatisticsMapper dailyMapper;

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
