package com.mysite.ProjSelPrac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.ProjSelPrac.Menu.Menu;
import com.mysite.ProjSelPrac.Menu.MenuRepository;



@SpringBootTest
class ProjSelPracApplicationTests {
	
	@Autowired
	private MenuRepository repo;
	
	@Test
	void contextLoads() {
		
//		SinglePostText spt = new SinglePostText();
//		spt.setSubject("1번게시물입니다");
//		spt.setCreateDate(LocalDateTime.now());
//		spt.setAutor("1번작성자");
//		spt.setViewcount(1234);
//		spt.setImportant(true);
//		spt.setMenu("커뮤니티");
//		spt.setCategory("자유게시판");
//		
//		SinglePostText spt2 = new SinglePostText();
//		spt2.setSubject("2번게시물입니다");
//		spt2.setCreateDate(LocalDateTime.now());
//		spt2.setAutor("2번작성자");
//		spt2.setViewcount(314);
//		spt2.setImportant(false);
//		spt2.setMenu("커뮤니티");
//		spt2.setCategory("자유게시판");
//		
//		SinglePostText spt3 = new SinglePostText();
//		spt3.setSubject("3번게시물입니다");
//		spt3.setCreateDate(LocalDateTime.now());
//		spt3.setAutor("3번작성자");
//		spt3.setViewcount(143);
//		spt3.setImportant(false);
//		spt3.setMenu("커뮤니티");
//		spt3.setCategory("자유게시판");
//		
//		SinglePostText spt4 = new SinglePostText();
//		spt4.setSubject("4번게시물입니다");
//		spt4.setCreateDate(LocalDateTime.now());
//		spt4.setAutor("4번작성자");
//		spt4.setViewcount(1242);
//		spt4.setImportant(false);
//		spt4.setMenu("커뮤니티");
//		spt4.setCategory("자유게시판");
//		
//		SinglePostText spt5 = new SinglePostText();
//		spt5.setSubject("5번게시물입니다");
//		spt5.setCreateDate(LocalDateTime.now());
//		spt5.setAutor("5번작성자");
//		spt5.setViewcount(1234);
//		spt5.setImportant(false);
//		spt5.setMenu("커뮤니티");
//		spt5.setCategory("자유게시판");
//		
//		this.repo.save(spt);
//		this.repo.save(spt2);
//		this.repo.save(spt3);
//		this.repo.save(spt4);
//		this.repo.save(spt5);
		
//		Random random = new Random();
//		for(int i=1;i<21;i++) {
//			SinglePostText spt5 = new SinglePostText();
//			int randomNumber = random.nextInt(9000) + 1000;
//			spt5.setSubject("일반게시판"+i+"번게시물입니다");
//			spt5.setCreateDate(LocalDateTime.now());
//			spt5.setAutor(i+"번작성자");
//			spt5.setViewcount(randomNumber);
//			spt5.setImportant(false);
//			spt5.setMenu("커뮤니티");
//			spt5.setCategory("일반게시판");
//			this.repo.save(spt5);
//		}
		
//		Menu menu = new Menu();
//		menu.setMenu("메뉴2");
//		menu.setCategoty("3번카테고리");
//		menu.setRate(2);
//		repo.save(menu);
		
//		Optional<SinglePostText> oq = this.repo.findById(7);
//        assertTrue(oq.isPresent());
//        SinglePostText q = oq.get();
//        this.repo.delete(q);
	}

}
