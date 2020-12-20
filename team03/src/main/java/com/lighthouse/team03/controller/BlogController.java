package com.lighthouse.team03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lighthouse.team03.entity.Blog;
import com.lighthouse.team03.mapper.BlogMapper;


@Controller
public class BlogController {
	@Autowired
	BlogMapper blogMapper;
	
	@PostMapping("/newBlogSubmission")
	public String newBlogSubmission(@RequestHeader("username") String usename, @ModelAttribute("blog") Blog blog,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		blog.setUsername(usename);
		blogMapper.addBlog(blog);
		
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE,HttpStatus.TEMPORARY_REDIRECT);
		redirectAttributes.addAttribute("userName",usename);
		return "redirect:/mypage";
	}
	
	@PostMapping("/editor")
	public String editor(@RequestHeader("username") String usename,Model model) {
		model.addAttribute("blog", new Blog());
		model.addAttribute("username" , usename);
		return "editor";
	}
	
	
}

