package com.emma.Blog.service;

import com.emma.Blog.exception.RecordNotFoundException;
import com.emma.Blog.model.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog createBlog(Map<String, Object> map);

    Blog updateBlog(Long blogId, Map<String, Object> map) throws RecordNotFoundException;

    List<Blog> readBlogs();

    Blog readBlog(Long blogId) throws RecordNotFoundException;
}
