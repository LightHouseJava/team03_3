package com.lighthouse.team03.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighthouse.team03.entity.Blog;
import com.lighthouse.team03.mapper.BlogMapper;


@Controller
public class MyPageControllar {
 
 @Autowired
 private BlogMapper blogMapper;
 
 @PostMapping(value = "/mypage")
 public String myPage(@RequestParam("userName")String userName,Model model) {
  List<Blog> blogs = blogMapper.getBlogsByUserName(userName);
  model.addAttribute("blogs",blogs);
  return "mypage";
 }

}


