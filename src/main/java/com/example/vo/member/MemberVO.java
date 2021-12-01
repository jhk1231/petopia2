package com.example.vo.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@ToString
@Alias("memberVo")
public class MemberVO{
    private @NonNull int no;
    private @NonNull String email;
    private String password;
    private @NonNull String nickname;
    private String regDate;
    private String lastDate;
    private String grade;
    private int gradeNo;
    private int docs;
    private int comms;
    private int visits;
    private String ban = "";
    private int isMember;
    
	public MemberVO(@NonNull String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public MemberVO(int no, String email, String grade, String nickname, String regDate, String lastDate, int docs, int comms,
			int visits, String ban, int isMember) {
		super();
		this.no = no;
		this.email = email;
		this.grade = grade;
		this.nickname = nickname;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.docs = docs;
		this.comms = comms;
		this.visits = visits;
		this.ban = ban;
		this.isMember = isMember;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no + "," + email + "," + nickname + "," + lastDate + "," + grade + "," + visits + "," + ban;
	}
   
}