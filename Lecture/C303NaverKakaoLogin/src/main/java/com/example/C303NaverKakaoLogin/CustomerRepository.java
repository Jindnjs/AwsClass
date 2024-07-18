package com.example.C303NaverKakaoLogin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByUsername(String username); // login check

}
