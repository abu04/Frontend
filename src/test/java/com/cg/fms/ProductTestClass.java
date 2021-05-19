package com.cg.fms;
/******************************
 * @author Anitha J Saini
 * Description: This is the JUNIT class for Product  module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.IProductDao;
import com.cg.fms.dto.Product;
import com.cg.fms.service.ProductServiceImpl;
@SpringBootTest
class ProductTestClass {

	@Autowired
	ProductServiceImpl productService;
	@Autowired
	IProductDao pdao;
	
	//GetProductById
	@Test
	void testGetProductById()
	{
		Product p= new Product(104,"sandalwood","10","tree");
		assertEquals(p.getProductName(),productService.serviceGetProduct(104).get().getProductName());
	}
	
	//AddProduct
	@Test
	void testAddProduct()
	{
		Product p=new Product(2,"Leaves","200","Green");
		productService.serviceAddProduct(p);
		assertEquals(p.getProductName(),productService.serviceGetProduct(2).get().getProductName());
	}
	
	//DeleteProduct
	@Test
	void testDeleteProduct()
	{	Product p=new Product(20,"Leaves20","8","Green");
		productService.serviceAddProduct(p);
	    assertEquals(true,productService.serviceDeleteProduct(20));
	}
	
	//GetAllProducts
	@Test
	void testGetAllProducts() 
	{
		List<Product> pro=productService.serviceGetAllProducts();
//		Product p1=new Product(1,"Wood","100","Brown");
//		Product p2=new Product(2,"Leaves","200","Green");
//		Product p3=new Product(3,"Flowers","300","Beautiful");
//		Product p4=new Product(4,"Cane","400","Medicine");
//		List<Product> expectedPro=new ArrayList<Product>();
//		expectedPro.add(p1);
//		expectedPro.add(p2);
//		expectedPro.add(p3);
//		expectedPro.add(p4);
		List<Product> expectedPro=pdao.findAll();
		assertArrayEquals(expectedPro.toArray(),pro.toArray());
		//assertEquals(expectedPro.get(1).getProductName(),pro.get(1).getProductName());
		
	}


}

