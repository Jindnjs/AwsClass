package com.example.C303NaverKakaoLogin.Product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public void create(Product product) {
		productRepository.save(product);
	}
	public List<Product> readList(){
		return productRepository.findAll();
	}
	public Product readdetail(Integer id) {
		return productRepository.findById(id).get();
	}
}
