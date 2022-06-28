package com.example.appkata.module.product.api;

import static com.example.appkata.common.config.CacheConfig.AppCacheTypeConstant.*;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appkata.module.product.application.CreateProductRequest;
import com.example.appkata.module.product.application.CreateProductResponse;
import com.example.appkata.module.product.application.FindProductResponse;
import com.example.appkata.module.product.application.ProductService;
import com.example.appkata.module.product.application.UpdateProductRequest;
import com.example.appkata.module.product.application.UpdateProductResponse;
import com.example.appkata.module.product.domain.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateProductResponse create(@RequestBody CreateProductRequest request) {
		Product product = productService.createProduct(request);
		return new CreateProductResponse(product);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@CachePut(value = FIND_PRODUCT_CACHE, key = "#request?.id")
	public UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest request) {
		Product updateProduct = productService.updateProduct(request);
		return new UpdateProductResponse(updateProduct);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Cacheable(value = FIND_PRODUCT_CACHE, key = "#id")
	public FindProductResponse getProduct(@PathVariable("id") Long id) {
		Product product = productService.findProduct(id);
		return new FindProductResponse(product);
	}
}
