package com.example.config;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.example.vo.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class SessionConfig implements HttpSessionListener, HttpSessionAttributeListener {

	private static Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

	public static Map<String, HttpSession> getSessions(){
		return sessions;
	}
	
	public static ArrayList<MemberVO> makeUserList() {
		ArrayList<MemberVO> userList = new ArrayList<MemberVO>();
		for(String key : sessions.keySet())
		{
			HttpSession session = sessions.get(key);
			MemberVO member = (MemberVO) session.getAttribute("loginUser");
			System.out.println(member.toString());
			userList.add(member);
		}
		return userList;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// HttpSessionListener.super.sessionCreated(se);
		System.out.println("session created");
		sessions.put(se.getSession().getId(), se.getSession());
		log.info("로그인 유저 : " + se.getSession().getAttribute("loginUser"));
		
		for(String key : sessions.keySet())
		{
			HttpSession session = sessions.get(key);
			MemberVO member = (MemberVO) session.getAttribute("loginUser");
			System.out.println(member.toString());
		}
//		sessions.forEach((key, value) -> {
//			System.out.println( (HttpSession)value.getAttribute("loginUser"));
//		});
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		//HttpSessionAttributeListener.super.attributeAdded(se);
		log.info("Session Attribute Added");
		log.info("로그인 유저 : " + se.getSession().getAttribute("loginUser"));
		for(String key : sessions.keySet())
		{
			HttpSession session = sessions.get(key);
			MemberVO member = (MemberVO) session.getAttribute("loginUser");
			System.out.println(member.toString());
		}
//		sessions.forEach((key, value) -> {
//			System.out.println( ((MemberVO)((HttpSession)value).getAttribute("loginUser")).toString());
//		});
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		//HttpSessionAttributeListener.super.attributeReplaced(se);
		log.info("Session Attribute Replaced");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// HttpSessionListener.super.sessionDestroyed(se);
		if (sessions.get(se.getSession().getId()) != null) {

			log.info("로그아웃 유저 : " + se.getSession().getAttribute("loginUser"));
			sessions.get(se.getSession().getId()).invalidate();
			sessions.remove(se.getSession().getId());
		}
	}

	// 중복로그인 지우기
	public synchronized static String getSessionidCheck(String AttributeName, String compareId) {
		String result = "";
		for (String key : sessions.keySet()) {
			HttpSession value = sessions.get(key);
//			if (value != null && value.getAttribute(AttributeName) != null
//					&& value.getAttribute(AttributeName).toString().equals(compareId)) {
//				System.out.println(compareId);
//				System.out.println(value.getAttribute(AttributeName).toString());
//				result = key.toString();
//			}
			if(value != null && value.getAttribute(AttributeName) != null) {
				String[] str = value.getAttribute(AttributeName).toString().split(",");
				log.info("로그인 멤버 넘버 : " + str[0]);
				if( str[0].equals(compareId)) {
					log.info("중복 로그인 삭제 : " + value.getAttribute(AttributeName).toString());
					
					result = key.toString();
				}
			}
		}
		removeSessionForDoubleLogin(result);
		return result;
	}

	private static void removeSessionForDoubleLogin(String userId) {
		if (userId != null && userId.length() > 0) {
			sessions.get(userId).invalidate();
			sessions.remove(userId);
		}
	}

}
