package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Product;
import com.abc.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired //bean definitions autowired
	private ProductService productService;
	
	@PostMapping("/savee") //save purpose we this
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {  //ResponseEntity represents an HTTP response, including headers, body, and status. While @ResponseBody puts the return value into the body of the response, ResponseEntity also allows us to add headers and status code.
		
		Product newProduct = productService.saveProduct(product);
		
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		
		return responseEntity;	
		
	}
	
	@GetMapping("/all") //for getting details we use this @GetMapping
	public List<Product> fecthAllProducts(Product product)
	{
		List<Product> products=productService.getAllProduct();
		return products;
		
	}
	
	@GetMapping("/get/{pid}")
	public  ResponseEntity<?> fetchProductDetails(@PathVariable("pid") int productId) {
		
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product Deleted with id: "+productId, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
}
