package com.example.C206Extra.Board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardService bs;
	@GetMapping("/")
	public String index() {
		//읽어오기 처리해야함
		return "Board";
	}
	
	@GetMapping("/write")
	public String create() {
		return "bwrite";
	}
	@PostMapping("/bwrite")
	public String noticewrite(@ModelAttribute Board board,
	        @RequestParam("image1") MultipartFile image1,
	        @RequestParam("image2") MultipartFile image2,
	        @RequestParam("image3") MultipartFile image3) throws IOException {
	    
	    List<MultipartFile> filelist = new ArrayList<>();
	    if (image1 != null && !image1.isEmpty()) {
	        filelist.add(image1);
	    }
	    if (image2 != null && !image2.isEmpty()) {
	        filelist.add(image2);
	    }
	    if (image3 != null && !image3.isEmpty()) {
	        filelist.add(image3);
	    }
	    
	    bs.create(board, filelist);
	    
	    return "redirect:/";
	}
	
}
