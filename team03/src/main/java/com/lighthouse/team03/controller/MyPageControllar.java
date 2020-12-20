package com.lighthouse.team03.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lighthouse.team03.entity.Blog;
import com.lighthouse.team03.mapper.BlogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MyPageControllar {
	
	@Autowired
	private BlogMapper blogMapper;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping(value = "/mypage")
	public String myPage(@RequestParam("userName") String userName, Model model) {
		
		List<Blog> blogs = blogMapper.getBlogsByUserName(userName);
		
		
		model.addAttribute("blogs", blogs);
		
		return "mypage";
	}

}
