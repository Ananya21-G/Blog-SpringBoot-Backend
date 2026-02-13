package com.blog.project.Controller;

import com.blog.project.Entity.BlogEntity;
import com.blog.project.Service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/secret")
public class PostDataController {
    private final BlogService blogService;

    public PostDataController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping
    public BlogEntity PostData(@RequestBody BlogEntity newBlog){
        return blogService.createBlog(newBlog);
    }

    @DeleteMapping("/{id}")
    public String DeleteBlog(@PathVariable UUID id){
        blogService.deleteBlog(id);
        return "Blog successfully deleted";
    }

    @PutMapping("/{id}")
    public BlogEntity updateBlogById(
            @PathVariable UUID id,
            @RequestBody BlogEntity updatedBlog) {

        return blogService.updateBlog(id, updatedBlog);
    }

}
