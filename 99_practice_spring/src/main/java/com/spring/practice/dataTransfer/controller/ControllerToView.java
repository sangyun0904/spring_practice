package com.spring.practice.dataTransfer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.dataTransfer.dto.MemberDto;

@Controller
public class ControllerToView {
	
	@RequestMapping(value="/modelEx" , method=RequestMethod.GET)
	public String modelEx(Model model) {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for (int i = 1; i < 11; i++) {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명" + i);
			memberDto.setHp("010-1234-5678");
			memberDto.setMemberGender("M");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setResidence("서울특별시");
			memberList.add(memberDto);
		}
		model.addAttribute("method" , "Model");
		model.addAttribute("memberList" , memberList);
		
		return "memberList";
	}
	
	@RequestMapping(value="/modelAndViewEx" , method=RequestMethod.GET)
	public ModelAndView modelAndViewEx() {
		ModelAndView mv = new ModelAndView("memberList");
		
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for (int i = 1; i < 11; i++) {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명" + i);
			memberDto.setHp("010-1234-5678");
			memberDto.setMemberGender("M");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setResidence("서울특별시");
			memberList.add(memberDto);
		}
		mv.addObject("method" , "ModelAndView");
		mv.addObject("memberList" , memberList);
		
		return mv;
	}
	
	@RequestMapping(value="/requestEx" , method=RequestMethod.GET)
	public String requestEx(HttpServletRequest request) {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for (int i = 1; i < 11; i++) {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId("memberId" + i);
			memberDto.setMemberName("익명" + i);
			memberDto.setHp("010-1234-5678");
			memberDto.setMemberGender("M");
			memberDto.setEmail("anonymous@gmail.com");
			memberDto.setResidence("서울특별시");
			memberList.add(memberDto);
		}
		request.setAttribute("method" , "Model");
		request.setAttribute("memberList" , memberList);
		
		return "memberList";
	}
	
	@RequestMapping(value="/responseBodyEx" , method=RequestMethod.GET)
	public @ResponseBody String responseBodyEx() {
		
		String data = "<script>";
			data += "alert('work');";
			data += "location.href='modelEx';";
			data += "</script>";
			
		return data;
			
	}
	
	@RequestMapping(value="/responseEntityEx" , method=RequestMethod.GET)
	public ResponseEntity<Object> responseEntityEx() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		String data = "<h1>html페이지를 반환합니다.</h1>";
		
		return new ResponseEntity<Object>(data, responseHeaders, HttpStatus.OK);
	}
	
}
