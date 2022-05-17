package com.study.springboot.customer.dto;

import lombok.Data;

@Data
public class CustRegiDto {
	private String name ;
	private String password ;
	private String authority ;
	private int enabled ;
}
