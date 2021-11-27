package com.example.vo.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("memberVo")
public class MemberVO {
	private int no;
	private String email;
	private String password;
	private String nickname;
	private String regDate;
	private String lastDate;
	private String grade;
	private int gradeNo;
	private int docs;
	private int comms;
	private int visits;
	private String ban;
	private int isMember;
	
	public MemberVO(int no, String email, String nickname, String regDate, String lastDate, String grade, int docs,
			int comms, int visits, String ban) {
		super();
		this.no = no;
		this.email = email;
		this.nickname = nickname;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.grade = grade;
		this.docs = docs;
		this.comms = comms;
		this.visits = visits;
		this.ban = ban;
	}
	
	
}
