package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Long> {

    void deleteBlogById(Long id);

    Blog getBlogById(Long id);

    Blog getBlogByTitle(String title);

    Blog findBlogById(long id);
}
