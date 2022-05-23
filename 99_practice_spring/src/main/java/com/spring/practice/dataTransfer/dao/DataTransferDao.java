package com.spring.practice.dataTransfer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.practice.dataTransfer.dto.ProductDto;

@Repository
public class DataTransferDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void selectData1() {
		
		System.out.println("\n selectData1 \n");
		
		int result = sqlSession.selectOne("dataTransferPrac.select1");
		System.out.println("결과 : " + result);
		
	}
	
	public void selectData2() {
		System.out.println("\n selectData2 \n");
		
		List<ProductDto> productList = sqlSession.selectList("dataTransferPrac.select2");
		for (ProductDto productDto : productList) {
			System.out.println(productDto);
		}
	}
	
}
