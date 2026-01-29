package com.blog.project.Controller;

import com.blog.project.Entity.BlogEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.project.Repository.BlogRepository;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{blogid}")
    public BlogEntity GetIdData(@PathVariable UUID blogid){

        BlogEntity blog = blogRepository.findById(blogid).orElseThrow(()-> new RuntimeException("Blog not found"));
        return blog;
    }
}
