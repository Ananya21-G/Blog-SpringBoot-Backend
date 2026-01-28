package com.blog.project.Repository;

import com.blog.project.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<BlogEntity, UUID>{
}
