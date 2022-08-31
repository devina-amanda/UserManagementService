package com.ttj.usermgmt.dao;


import com.ttj.usermgmt.model.DAOProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<DAOProduct, Integer> {
	
}

