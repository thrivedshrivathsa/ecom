package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exceptionhandling.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		Product savedProduct=productRepository.save(product);
		return savedProduct;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFoundException {
		
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: "+productId);
		}
		else {
			return optionalProduct.get();
		}
		
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product>optionalProduct=productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Sorry! Product is not exixting with id :"+product.getProductId());
		}
		Product updateproduct = productRepository.save(product);
		
		return updateproduct;
	}

	@Override
	public void deleteProduct(int productId) {
		Optional<Product> optionalProduct=productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {			
			productRepository.deleteById(productId);			
		}
		else {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: "+productId);
		}
	}
	
}


