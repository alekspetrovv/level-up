package level.up.example.controller;

import level.up.example.module.Blog;
import level.up.example.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blog>> readAll() {
        List<Blog> blogs = blogService.read();
        if (blogs != null) {
            return ResponseEntity.ok().body(blogs);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> read(@PathVariable("id") Long id) {
        Blog blog = blogService.get(id);
        if (blog != null) {
            return ResponseEntity.ok().body(blog);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/add")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog newBlog = blogService.create(blog);
        if (newBlog != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @PutMapping("/update")
    public ResponseEntity<Blog> update(@RequestBody Blog blog) {
        Blog updateBlog = blogService.update(blog);
        if (updateBlog != null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

}