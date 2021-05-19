package com.cg.fms.service;
/******************************
 * @author       Anitha J Saini
 * Description : This is the Service class for Products. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.fms.dto.Product;
@Service
public interface ProductService {
    public Optional<Product> serviceGetProduct(int productId);
	
	public boolean serviceAddProduct(Product product);

	public Product serviceUpdateProduct(Product product);

	public Product serviceDeleteProduct(int productId);
	
	public List<Product> serviceGetAllProducts();

}
