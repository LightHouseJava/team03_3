package com.lighthouse.team03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lighthouse.team03.entity.User;
import com.lighthouse.team03.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
	@Autowired
	private UserMapper userMapper;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	@PostMapping("/loginSubmission")
	public String loginSubmisstion(@ModelAttribute("loginUser") User loginUser, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT); // post redirect
		if(userMapper.checkUserExists(loginUser.getUserName())) {
			User tmpUser = userMapper.findByUserName(loginUser.getUserName());
			if(tmpUser.getPassword().equals(loginUser.getPassword())) {
				redirectAttributes.addAttribute("userName", loginUser.getUserName());
				logger.info("mypage:"+loginUser.getUserName());
				return "redirect:/mypage";
			}
			else
				logger.info("failed_page-2");
				return "redirect:/failed_page";
		}else
			logger.info("failed_page-3");
			System.out.print("failed_page-3");
			return "redirect:/failed_page";
	}
	
	@PostMapping("/failed_page")
	public String failed_page() {
		return "failed_page";
	}
	
		
}
