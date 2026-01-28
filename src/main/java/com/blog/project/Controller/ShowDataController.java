package com.blog.project.Controller;

import com.blog.project.Entity.BlogEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.project.Repository.BlogRepository;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class ShowDataController {
    private final BlogRepository blogRepository;

    public ShowDataController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public List<BlogEntity> GetData(){
    return blogRepository.findAll();
    }
}
