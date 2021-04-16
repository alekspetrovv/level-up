package level.up.example.repository;

import level.up.example.module.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Long> {

    void deleteBlogById(Long id);

    Blog getBlogById(Long id);

    Blog getBlogByTitle(String title);

    Blog findBlogById(long id);
}
