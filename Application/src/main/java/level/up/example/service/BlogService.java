package level.up.example.service;

import level.up.example.exception.BlogNotFoundException;
import level.up.example.exception.UserNotFoundException;
import level.up.example.module.Blog;
import level.up.example.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    public Blog create(Blog blog) {
        Blog existingBlog = blogRepository.getBlogByTitle(blog.getTitle());
        if (existingBlog != null) {
            throw new UserNotFoundException("Blog with title: " + blog.getTitle() + " already exist!");
        }
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
        if (existingBlog == null) {
            return null;
        }
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setBody(blog.getBody());
        return blogRepository.save(blog);
    }

    @Transactional
    public void delete(Long id) {
        Blog existingBlog = get(id);
        if (existingBlog == null) {
            return;
        }
        blogRepository.deleteBlogById(id);
    }

}
