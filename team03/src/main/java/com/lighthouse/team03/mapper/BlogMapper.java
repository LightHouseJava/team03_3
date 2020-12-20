package com.lighthouse.team03.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lighthouse.team03.entity.Blog;


	
	@Mapper
	public interface BlogMapper {
	 
	public List<Blog>getBlogsByUserName(@Param("username")String userName);
	 
	 @Insert("insert into blogs values (#{blog.username},#{blog.title},#{blog.subtitle},#{blog.body},#{blog.image})")
	 public void addBlog(@Param("blog") Blog blog);
	  
	 
	}
