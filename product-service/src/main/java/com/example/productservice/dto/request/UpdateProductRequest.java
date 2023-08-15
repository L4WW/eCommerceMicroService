package com.example.productservice.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	@NotNull
	private Long id;
	@NotNull
	@NotBlank
	private String name;
	private String description;
	@NotNull
	private BigDecimal price;

}
