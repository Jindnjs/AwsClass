package com.example.C203BucketExam;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {

	private final NoticeRepository nr;
	private final S3Service s3Service;
	
	//multipartfile = 사진파일
	public void create(Notice notice, MultipartFile file1) throws IOException {
		
		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid +"_"+ file1.getOriginalFilename();
		
		//버킷에 사진업로드
		s3Service.uploadFile(file1, fileName1);
		
		notice.setImage1(fileName1);
		//DB에 제목 내용등을 저장 + 사진이름
		nr.save(notice);
	}
	
	public List<Notice> readlist(){
		return nr.findAll();
	}
}
