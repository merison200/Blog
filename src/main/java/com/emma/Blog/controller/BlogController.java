package com.emma.Blog.controller;

import com.emma.Blog.model.Blog;
import com.emma.Blog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

@RestController
@Validated
@RequestMapping("/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("blog")
    public Callable<Blog> createBlog(@Valid @RequestBody Map<String, Object> map) {

        return () -> blogService.createBlog(map);
    }

    @GetMapping("blog")
    public Callable<List<Blog>> readBlog() {

        return () -> blogService.readBlogs();
    }

    @PutMapping("blog/{blogId}")
    public Callable<Blog> updateBlog(@Valid @PathVariable Long blogId,
                                     @Valid @RequestBody Map<String, Object> map) {

        return () -> blogService.updateBlog(blogId, map);
    }

    @GetMapping("blog/{blogId}")
    public Callable<Blog> updateBlog(@Valid @PathVariable Long blogId) {

        return () -> blogService.readBlog(blogId);
    }
}
