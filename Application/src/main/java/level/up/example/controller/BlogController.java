package level.up.example.controller;

import level.up.example.module.Blog;
import level.up.example.module.FileUtility;
import level.up.example.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
@Validated
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
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


    @PostMapping(value = "")
    public ResponseEntity<?> create(
            @RequestParam("file") MultipartFile multipartFile,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("body") String body
    ) throws IOException {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);


        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        blog.setImg(fileName);
        Blog newBlog = blogService.create(blog);

        String uploadDir = "img/maps/" + newBlog.getId();

        FileUtility.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            @PathVariable long id,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("body") String body
    ) {

        Blog blog = blogService.findBlogById(id);
        blog.setTitle(title);
        blog.setBody(body);

        Blog updatedBlog = blogService.update(blog);

        return new ResponseEntity<>(updatedBlog, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

}