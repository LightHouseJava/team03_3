package com.lighthouse.team03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.lighthouse.team03.entity.Blog;

@Mapper
public interface BlogMapper {

	public List<Blog> getBlogsByUserName(@Param("username") String userName);
	
	@Insert("insert into blogs values (#{blog.userName},#{blog.title},#{blog.subtitle},#{blog.body},#{blog.image})")
	public void addBlog(@Param("blog") Blog blog);
	
	
}
