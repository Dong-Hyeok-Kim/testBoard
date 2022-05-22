package com.study.springboot.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.account.dto.AccountDto;
       
@Mapper
public interface IAccountDao {
	public List<AccountDto> accountListDao(String name);
	public int sendDao(String account, int balance);
	public int receiveDao(String account, int balance);
}
