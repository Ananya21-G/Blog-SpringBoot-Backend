package com.blog.project.Service;

import com.blog.project.DTO.BlogSummaryDTO;
import com.blog.project.Entity.BlogEntity;
import com.blog.project.Repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<BlogSummaryDTO> getAllBlogs(){
        return blogRepository.findAllBlogSummaries();
    }

    public BlogEntity getBlogById(UUID blogId) {
        return blogRepository.findById(blogId).orElseThrow(() ->new RuntimeException("Blog not found"));
    }

    public BlogEntity createBlog(BlogEntity newBlog){
        return blogRepository.save(newBlog);
    }

    public void deleteBlog(UUID id){
        blogRepository.deleteById(id);
    }

    public BlogEntity updateBlog(UUID id,BlogEntity updatedBlog){
        BlogEntity existingBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not Found"));

        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        existingBlog.setDescription(updatedBlog.getDescription());
        existingBlog.setMood(updatedBlog.getMood());

        return blogRepository.save(existingBlog);
    }
}
