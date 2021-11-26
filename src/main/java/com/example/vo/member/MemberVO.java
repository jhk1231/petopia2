package com.example.vo.member;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Alias("memberVo")
public class MemberVO {
    private @NonNull int no;
    private @NonNull String email;
    private String password;
    private String nickname;
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
    
   
}