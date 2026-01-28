package com.blog.project.Repository;

import com.blog.project.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, String>{
}
