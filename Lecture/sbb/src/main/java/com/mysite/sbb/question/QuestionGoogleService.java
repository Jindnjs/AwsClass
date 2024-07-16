package com.mysite.sbb.question;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.S3Service;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

@Primary
@Service
public class QuestionGoogleService implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private JavaMailSender mailsender;
	
	@Autowired
	private UserService userService;

    public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else { // 조회할 데이터가 디비에 존재하지 않을 경우 예외 처리
            throw new DataNotFoundException("question not found");
        }
    }

	@Override
	public List<Question> readlist() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}
    
    public void create(Question question, MultipartFile file1) throws IOException {
    	//네이버 메일 발송
    	
    	SiteUser user =  userService.authen();
    	
    	
    	SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("jin031043@gmail.com");//설정한 네이버 메일 주소만 사용, 변조 불가
		message.setTo(user.getEmail());//수신자 메일 주소 
		message.setSubject("다음의 제목으로 글이 등록되었습니다. [" + question.getSubject() + "]"); //메일 제목
		message.setText(question.getContent());//메일 내용 
		
		mailsender.send(message);
    	
    	
    	
    	
    	
    	//사진 처리
		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid + "_" + file1.getOriginalFilename(); //uuid만들어서 사진 쏴주고
		
		s3Service.uploadFile(file1, fileName1);
		
		question.setImage1(fileName1);
    	question.setUser(user);
        question.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    public void delete(Integer id) {
    	questionRepository.deleteById(id);
    }

	@Override
	public List<Question> searchkw(String kw) {
		// TODO Auto-generated method stub
		
		return questionRepository.findBySubjectContaining(kw);
	}


}
