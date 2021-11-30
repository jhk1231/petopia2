package com.example.vo.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//아래 어노테이션만 붙여주고, 별칭 설정해주는거 외에 값은 기존 자바스크립트거 그대로 가져와도 된다!!//
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("memberVO")
@RequiredArgsConstructor
public class MemberVO {
	public MemberVO(int memberNo, int gradeNo, String email, String password, String nickname) {
		this.gradeNo = gradeNo;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	private int no;
	@NonNull
	private String email;
	@NonNull
	private String password;
	@NonNull
	private String nickname;
	private String regDate;
	private String lastDate;
	private String grade;
	@NonNull
	private int gradeNo;
	private int docs;
	private int comms;
	private int visits;
	private String ban;
	private int isMember;
}
