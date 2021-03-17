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

    @GetMapping("/all")
    public ResponseEntity<List<Blog>> readAll() {
        List<Blog> blogs = blogService.read();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> read(@PathVariable("id") Long id) {
        Blog blog = blogService.get(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog newBlog = blogService.create(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Blog> update(@RequestBody Blog blog) {
        Blog updateBlog = blogService.update(blog);
        return new ResponseEntity<>(updateBlog, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}