package com.mangesh.food.dto;

import com.mangesh.fomobject.Category;
import com.mangesh.fomobject.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
	
	private Integer id;
	
	private String productName;
	
	private Integer categoryId;
	
	private String categoryName;
	
	private Double price;
	
	private Integer quantity;

	private String description;
	
	private String imageName;
	
	
//	public static Product toEntity(ProductDTO dto) {
//		Product product = new Product();
//		product.setId(dto.getId());
//		product.setProductName(dto.getProductName());
//		
//		Category category = new Category();
//		category.setId(dto.getCategoryId());
//		category.setName(dto.getCategoryName());
//		
//		product.setCategory(category);
//		product.setPrice(dto.getPrice());
//		product.setQuantity(dto.getQuantity());
//		product.setDescription(dto.getDescription());
//		product.setImageName(dto.getImageName());
//		return product;
//	}
	
	
	
	
//	public static ProductDTO toDTO(Product product) {
//		ProductDTO dto = new ProductDTO();
//		dto.setId(product.getId());
//		dto.setProductName(product.getProductName());
//		dto.setCategoryId(product.getCategory().getId());
//		dto.setCategoryName(product.getCategory().getName());
//		dto.setPrice(product.getPrice());
//		dto.setQuantity(product.getQuantity());
//		dto.setDescription(product.getDescription());
//		dto.setImageName(product.getImageName());
//		return dto;
//	}
	
	 public static Product toEntity(ProductDTO dto) {
	        return Product.builder()
	                .id(dto.getId())
	                .productName(dto.getProductName())
	                .category(Category.builder()
	                        .id(dto.getCategoryId())
	                        .name(dto.getCategoryName())
	                        .build())
	                .price(dto.getPrice())
	                .quantity(dto.getQuantity())
	                .description(dto.getDescription())
	                .imageName(dto.getImageName())
	                .build();
	    }
	
	 
	 public static ProductDTO toDTO(Product product) {
	        return ProductDTO.builder()
	                .id(product.getId())
	                .productName(product.getProductName())
	                .categoryId(product.getCategory().getId())
	                .categoryName(product.getCategory().getName())
	                .price(product.getPrice())
	                .quantity(product.getQuantity())
	                .description(product.getDescription())
	                .imageName(product.getImageName())
	                .build();
	    }
	
	
}
