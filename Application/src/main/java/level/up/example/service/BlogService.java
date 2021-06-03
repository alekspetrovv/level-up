package level.up.example.service;

import level.up.example.exception.BlogNotFoundException;
import level.up.example.exception.UserNotFoundException;
import level.up.example.module.Blog;
import level.up.example.module.FileUtility;
import level.up.example.repository.BlogRepository;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
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


    public Blog findBlogById(Long id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new BlogNotFoundException("Blog with id " + id + " was not found!");
        }
        return blog;
    }


    public Blog update(Blog blog) {
        return blogRepository.save(blog);
    }

    @Transactional
    public void delete(Long id) throws IOException {
        Blog existingBlog = get(id);
        if (existingBlog == null) {
            return;
        }
        FileUtils.deleteDirectory(new File("src/main/resources/img/blogs/" + id));
        blogRepository.deleteBlogById(id);
    }

}
