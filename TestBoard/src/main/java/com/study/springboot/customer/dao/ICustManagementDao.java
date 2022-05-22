package com.study.springboot.customer.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICustManagementDao {
	public int custRegiDao(String name, String password, String authority);
}
