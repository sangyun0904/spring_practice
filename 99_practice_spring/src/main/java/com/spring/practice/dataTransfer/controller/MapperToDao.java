package com.spring.practice.dataTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.practice.dataTransfer.dao.DataTransferDao;

@Controller
public class MapperToDao {
	
	@Autowired
	private DataTransferDao dataTransferDao;
	
	@RequestMapping(value="/selectData1" , method=RequestMethod.GET)
	public String selectData1() {
		dataTransferDao.selectData1();
		return "home";
	}
	
}
