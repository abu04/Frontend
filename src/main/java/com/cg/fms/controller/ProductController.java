package com.cg.fms.controller;
/******************************
 * @author Anitha J Saini
 * Description: This is the rest controller class for Product. 
 * Created Date: 23 April, 2021 
 * Version : v1.1.0
 *****************************/
	
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;


import com.cg.fms.dto.Product;
import com.cg.fms.exception.NoDataFoundException;
import com.cg.fms.service.ProductServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")	
@RestController   
	@RequestMapping("/product")
	public class ProductController
	{

		@Autowired
		ProductServiceImpl productService;
		
		public ProductServiceImpl getProductDAO()
		{
			return productService;
		}
		public void setProductDAO(ProductServiceImpl productService)
		{
			this.productService=productService;
			
		}
		/*******************************
		 * Method      : getAll      
		 * @return       List of Product object
		 * Description : This method fetches all the products from database.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ******************************/
		@GetMapping(value="/all",produces="application/json")
		public  ResponseEntity<List<Product>> getProducts()
		{ 
			return new ResponseEntity<List<Product>> (productService.serviceGetAllProducts(),HttpStatus.OK);
		}
		/*******************************
		 * Method      : getById       
		 * @param        Id
		 * @return       Product object
		 * Description : This method fetches a product based on the unique id.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ******************************/
		@GetMapping(value="/get/{productId}",produces="application/json")
		public ResponseEntity<Optional<Product>> getProduct(@PathVariable("productId")int productId)
		{ 	
			Optional<Product> p=productService.serviceGetProduct(productId);
	    	System.out.println(p);
	    	if(p.isPresent()) {
	    		return new ResponseEntity<Optional<Product>>(p,HttpStatus.OK);
	    	}
	    	else 
	    		throw new NoDataFoundException("No Product data found with given Product ID: "+ productId);
		
		}

		/***********
		 * Method      : addProduct      
		 * @param        Product
		 * @return       Response Entity of Object type
		 * Description : This method adds a new Product.
		 * @posttmapping: Post mapping requests a body from the user which is then persisted onto the database.
		 **********/
		@PostMapping(consumes="application/json")
		public ResponseEntity<HttpStatus> addProduct(@RequestBody Product product)
		{
			productService.serviceAddProduct(product);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		}
		/***********
		 * Method      : updateProduct      
		 * @param        Product
		 * @return       Response Entity of Object type
		 * Description : This method updates the product details.
		 * @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
		 **********/
		@PutMapping(value="/update/{productId}",produces="application/json")
		public ResponseEntity<Product> updateProduct(@PathVariable("productId")int productId,@RequestBody Product product){
		Optional<Product> l=null;
		l=productService.serviceGetProduct(productId);
		l.get().setProductId(product.getProductId());
		l.get().setProductName(product.getProductName());
		l.get().setProductDescription(product.getProductDescription());
		l.get().setProductQuantity(product.getProductQuantity());
		final Product updatedProduct= productService.serviceUpdateProduct(l.get());
		if(l.isPresent()) {
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
		}
		else
		throw new NoDataFoundException("No product data found with given product ID: "+ productId);
		}
		/***********
		 * Method      : deleteProduct      
		 * @param        Id
		 * @return       Response Entity of Object type
		 * Description : This method deletes the product based on id.
		 * @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
		 **********/
		@DeleteMapping(value="/{productId}")
		public ResponseEntity<HttpStatus> deleteEmlpoyee(@PathVariable("productId")int productId)
		{
			
			Optional<Product> p=productService.serviceGetProduct(productId);
	    	System.out.println(p);
	    	if(p.isPresent()) {
	    		productService.serviceDeleteProduct(productId);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    	}
	    	else 
	    		throw new NoDataFoundException("No Product data found with given Product ID: "+ productId);
		}
		

		

	}


