package level.up.example.controller;

import level.up.example.exception.UserNotFoundException;
import level.up.example.module.ApiUser;
import level.up.example.module.Blog;
import level.up.example.module.FileUtility;
import level.up.example.service.BlogService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/blogs")
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


    @PostMapping("")
    public ResponseEntity<Blog> create(
            @RequestParam("file") MultipartFile multipartFile,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("body") String body,
            @NotNull @RequestParam("user_id") ApiUser user
    ) throws IOException {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);

        if (user == null) {
            throw new UserNotFoundException("User does not exist!");
        }

        blog.setApi_user(user);


        if (multipartFile.isEmpty()) {
            throw new RuntimeException("Please load a picture");
        }


        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        blog.setImg(fileName);
        Blog newBlog = blogService.create(blog);
        String uploadDir = "src/main/resources/img/blogs/" + newBlog.getId();
        FileUtility.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<Blog>(newBlog, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            @PathVariable long id,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("body") String body
    ) throws IOException {

        Blog blog = blogService.findBlogById(id);
        blog.setTitle(title);
        blog.setBody(body);

        if (multipartFile != null) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileUtils.deleteDirectory(new File("src/main/resources/img/blogs/" + blog.getId()));
            blog.setImg(fileName);
            String uploadDir = "src/main/resources/img/blogs/" + blog.getId();
            FileUtility.saveFile(uploadDir, fileName, multipartFile);
        }

        Blog updatedBlog = blogService.update(blog);
        return new ResponseEntity<>(updatedBlog, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) throws IOException {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

}