package com.study.springboot.customer.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustManagementDao {
	public int CustRegiDao(String name, String password);
}
