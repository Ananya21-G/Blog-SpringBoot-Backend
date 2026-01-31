package com.blog.project.Repository;

import com.blog.project.DTO.BlogSummaryDTO;
import com.blog.project.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BlogRepository extends JpaRepository<BlogEntity, UUID>{
    @Query("""
        SELECT new com.blog.project.DTO.BlogSummaryDTO(
            b.id,
            b.title,
            b.description,
            b.mood,
            b.createdAt
        )
        FROM BlogEntity b
    """)
    List<BlogSummaryDTO> findAllBlogSummaries();
}
