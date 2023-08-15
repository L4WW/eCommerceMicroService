package com.example.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productservice.dto.request.CreateProductRequest;
import com.example.productservice.dto.request.UpdateProductRequest;
import com.example.productservice.dto.response.GetAllProductsResponse;
import com.example.productservice.dto.response.GetProductByIdResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;
	
	public void createProduct(CreateProductRequest request) {
		Product product = Product.builder()
				.name(request.getName())
				.description(request.getDescription())
				.price(request.getPrice())
				.build();
		
		productRepository.save(product);
		
	}
	
	public List<GetAllProductsResponse> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> mapToGetAllProductResponse(product)).toList();
	}
	
	public GetProductByIdResponse getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		GetProductByIdResponse response = GetProductByIdResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		return response;
				
		
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	
	public void updateProduct(UpdateProductRequest request) {
		Product product = Product.builder()
				.id(request.getId())
				.name(request.getName())
				.description(request.getDescription())
				.price(request.getPrice())
				.build();
		productRepository.save(product);
	}
	
	private GetAllProductsResponse mapToGetAllProductResponse(Product product) {
		return GetAllProductsResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		
	}

}
