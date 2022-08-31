package com.ttj.usermgmt.controller;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ttj.usermgmt.dao.ProductDao;
import com.ttj.usermgmt.model.DAOProduct;
import com.ttj.usermgmt.model.ProductDTO;
import com.ttj.usermgmt.service.ProductServices;



@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;


	@Autowired
	private ProductServices productServices;
	
	@GetMapping("/getListProduct")  
	private List<DAOProduct> getAllProduct()   
	{  
	return productServices.getAllProduct();  
	}  
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO product) throws SQLException, ClassNotFoundException {
		productServices.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
	
	@PutMapping("/updateProduct")  
	private DAOProduct update(@RequestBody DAOProduct product)   
	{  
		productServices.saveOrUpdate(product);  
	return product;  
	} 
	
	@DeleteMapping("/deleteProduct/{id}")
	private void deleteProduct(@PathVariable(value ="id") int id)   
	{  
		productServices.delete(id);  
	}  
	
	
	
	
}