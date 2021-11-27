package com.example.vo.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@ToString
@Alias("memberVo")
public class MemberVO {
    private @NonNull int no;
    private @NonNull String email;
    private String password;
    private @NonNull String nickname;
    private String regDate;
    private String lastDate;
    private int grade;
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
  
  public MemberVO(@NonNull int no, @NonNull String email, @NonNull String nickname, String regDate, String lastDate, String grade, int docs,
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
  
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no + "," + email + "," + nickname + "," + lastDate + "," + grade + "," + visits + "," + ban;
	}
    
}

