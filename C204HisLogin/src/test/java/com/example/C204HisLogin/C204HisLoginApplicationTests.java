package com.example.C204HisLogin;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class C204HisLoginApplicationTests {
	
	@Autowired
	private CustomerRepository cr;
	
	@Test
	void contextLoads() {
	
		
		Customer customer = new Customer();
		
		customer.setUsername("user");
		customer.setPassword("user");
		
		customer.setEnabled(true);
		customer.setRole("ROLE_USER"); //ROLE_ADMIN, ROLE_MANAGER, ROLE_PAID...
		customer.setCdate(LocalDateTime.now());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		cr.save(customer);

	}

}
