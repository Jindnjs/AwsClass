package com.example.C203Jpaexam;

import java.util.List;

public interface UserService {
		void create(User user);
		
		List<User> readlist();
		
		User readdetail(Integer uno);
}
	