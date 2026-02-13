package com.blog.project.Controller;

import com.blog.project.DTO.BlogSummaryDTO;
import com.blog.project.Entity.BlogEntity;
import org.springframework.web.bind.annotation.*;
import com.blog.project.Service.BlogService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "https://ananya-blog.vercel.app")

public class ShowDataController {
    private final BlogService blogService;

    public ShowDataController(BlogService blogService){
        this.blogService = blogService;
    }


    @GetMapping
    public List<BlogSummaryDTO> GetData(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/{blogid}")
    public BlogEntity GetIdData(@PathVariable UUID blogid){

        return blogService.getBlogById(blogid);
    }
}

