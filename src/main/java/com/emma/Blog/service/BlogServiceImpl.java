package com.emma.Blog.service;

import com.emma.Blog.exception.RecordNotFoundException;
import com.emma.Blog.model.Blog;
import com.emma.Blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog createBlog(Map<String, Object> map) {
        Blog blog = new Blog();
        blog.setTitle(map.get("title").toString());
        blog.setDescription(map.get("description").toString());
        blog.setIsPublished(true);
        blog.setCreatedOn(Date.valueOf(LocalDate.now()));
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long blogId, Map<String, Object> map)
            throws RecordNotFoundException {

        Blog blog = readBlog(blogId);
        blog.setTitle(map.get("title").toString());
        blog.setDescription(map.get("description").toString());
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> readBlogs() {
        return blogRepository.findAllByIsPublished(true);
    }

    @Override
    public Blog readBlog(Long blogId) throws RecordNotFoundException {
        Optional<Blog> blogOptional = blogRepository.findById(blogId);
        Blog blog = blogOptional.orElseThrow(() -> new RecordNotFoundException("Record"));
        return blog;
    }
}
