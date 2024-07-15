package com.example.C301MailExam;

import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Override
	public void create(String title, String content,String addr) {
		// TODO Auto-generated method stub
		
		System.out.println("네이버 메일을 전송합니다");
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("주소 : " + addr);
	}

}
