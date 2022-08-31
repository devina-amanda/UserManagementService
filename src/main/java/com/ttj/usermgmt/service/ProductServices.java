package com.ttj.usermgmt.service;



import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttj.usermgmt.dao.ProductDao;
import com.ttj.usermgmt.model.DAOProduct;
import com.ttj.usermgmt.model.ProductDTO;



@Service
public class ProductServices {
	@Autowired
    private ProductDao productDao;
	
	public List<DAOProduct> getAllProduct()   {  
	List<DAOProduct> product = new ArrayList<DAOProduct>();  
	productDao.findAll().forEach(product2 -> product.add(product2));  
	return product; 
	}

    public DAOProduct save(ProductDTO product) {
        DAOProduct newProduct = new DAOProduct();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        return productDao.save(newProduct);
    }
    
    public void saveOrUpdate(DAOProduct product)   
    {  
    productDao.save(product);  
    } 
    
    public void update(DAOProduct product, int id)   
    {  
    productDao.save(product);  
    }  
    
    public void delete(int id)   
    {  
    productDao.deleteById(id);  
    }  
    
    
   
    
}

