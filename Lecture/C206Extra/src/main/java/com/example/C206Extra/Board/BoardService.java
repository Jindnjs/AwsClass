package com.example.C206Extra.Board;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.C206Extra.Bucket.S3Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository br;
	private final S3Service s3Service;
	
	public void create(Board board, List<MultipartFile> filelist) throws IOException {
		List<String> filenamelist = new ArrayList<>();
		
		for (MultipartFile file : filelist) {
			if (file != null && !file.isEmpty()) {
				String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
				filenamelist.add(fileName);
				s3Service.uploadFile(file, fileName);
			}
		}
		
		board.setImagelist(filenamelist);
		board.setDate(LocalDateTime.now());
		br.save(board);
	}
	
}
