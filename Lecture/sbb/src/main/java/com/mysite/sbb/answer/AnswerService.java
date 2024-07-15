package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    
	private final JavaMailSender mailsender;

    public void create(Question question, String content) {
    	
    	// 게시물 원작성자의 이메일 정보알아내기
    	SiteUser user = question.getUser();
  
    	
    	SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("sojourn8th@naver.com");//설정한 네이버 메일 주소만 사용, 변조 불가
		message.setTo(user.getEmail());//수신자 메일 주소 
		message.setSubject("회원님께서 쓰신 글에 답변이 달렸습니다."); //메일 제목
		message.setText(content);//메일 내용 
		
		mailsender.send(message);
    	
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}