package com.example.controller;

import java.security.SecureRandom;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.member.MemberService;
import com.example.vo.member.MemberVO;

@Controller
public class MailController {

	@Autowired
	public JavaMailSender javaMailSender;
	
	@Autowired
	public MemberService memberService;
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestParam("email") String email) throws MessagingException {
		
		System.out.println(email);
		char[] charSet = new char[] {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
				'!', '@', '#', '$', '%', '&' }; 
		
		StringBuffer sb = new StringBuffer(); 
		SecureRandom sr = new SecureRandom(); 
		sr.setSeed(new Date().getTime()); 
		int idx = 0; 
		int len = charSet.length; 
		for (int i=0; i < 12; i++) 
		{ // idx = (int) (len * Math.random()); 
			idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다. 
			sb.append(charSet[idx]); 
		}
		
		MemberVO mVo = new MemberVO(email, sb.toString());
		this.memberService.updateTempPassword(mVo);
		MimeMessage message = javaMailSender.createMimeMessage();
		message.setFrom(new InternetAddress("studydev1234@naver.com"));
		message.setSubject("페토피아 임시 비밀번호 발급");
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setText("임시 비밀번호 : " + sb.toString());
		message.setSentDate(new Date());
		
		javaMailSender.send(message);
		
		return "redirect:petopialogin";
	}
	
}
