package com.example.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dto.request.CreateProductRequest;
import com.example.productservice.dto.request.UpdateProductRequest;
import com.example.productservice.dto.response.GetAllProductsResponse;
import com.example.productservice.dto.response.GetProductByIdResponse;
import com.example.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
	private final ProductService productService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody @Valid CreateProductRequest request) {
		productService.createProduct(request);
	}
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@RequestParam Long id) {
		productService.deleteById(id);
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/getallproducts")
	public List<GetAllProductsResponse> getAllProducts() {
		return productService.getAllProducts();
	}
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/getproduct/{id}")
	public GetProductByIdResponse getProductById(@RequestParam Long id) {
		return productService.getProductById(id);
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@RequestBody @Valid UpdateProductRequest request) {
		productService.updateProduct(request);
	}

}
