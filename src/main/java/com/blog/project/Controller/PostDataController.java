package com.blog.project.Controller;

import com.blog.project.Entity.BlogEntity;
import com.blog.project.Repository.BlogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogay")
public class PostDataController {
    private final BlogRepository blogRepository;

    public PostDataController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @PostMapping
    public BlogEntity PostData(@RequestBody BlogEntity newBlog){
        return blogRepository.save(newBlog);
    }

    @DeleteMapping("/{id}")
    public String DeleteBlog(@PathVariable String id){
        blogRepository.deleteById(id);
        return "Blog successfully deleted";
    }
}
