package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.models.FileUtility;
import com.bezkoder.springjwt.security.services.BlogService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

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
            @NotBlank @RequestParam("body") String body
    ) throws IOException {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);


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
    @Transactional
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) throws IOException {
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

}
