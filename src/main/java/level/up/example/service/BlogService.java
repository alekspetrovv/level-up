package level.up.example.service;

import level.up.example.exception.BlogNotFoundException;
import level.up.example.module.Blog;
import level.up.example.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> read() {
        return blogRepository.findAll();
    }

    public Blog get(Long id) {
        Blog blog = blogRepository.getBlogById(id);
        if (blog == null) {
            throw new BlogNotFoundException("Blog with id: " + id + " is not found!");
        }
        return blog;
    }

    public Blog update(Blog blog) {
        Blog existingBlog = get(blog.getId());
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setBody(blog.getBody());
        return blogRepository.save(blog);
    }

    @Transactional
    public void delete(Long id) {
        blogRepository.deleteBlogById(id);
    }

}
