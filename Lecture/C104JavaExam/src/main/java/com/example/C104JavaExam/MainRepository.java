package com.example.C104JavaExam;

import org.springframework.stereotype.Repository;

@Repository
public class MainRepository {

	public void repositoryCreate(String id, String pass) {
		
		System.out.println("리포지토리에서 출력id = " + id);
		System.out.println("리포지토리에서 출력pw = " + pass);
	}
}
