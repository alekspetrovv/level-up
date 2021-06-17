package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exception.BlogNotFoundException;
import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.security.services.BlogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
class BlogControllerTest {


    @InjectMocks
    BlogController blogController;

    @Mock
    private BlogService blogService;
    @Test
    void readAll() {

        List<Blog> blogList = new ArrayList<>();

        ResponseEntity<List<Blog>> expected = ResponseEntity.ok().body(blogList);

        when(blogService.read()).thenReturn(blogList);

        ResponseEntity<List<Blog>> actual = blogController.readAll();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void read() throws BlogNotFoundException {

        Blog blog = this.getBlog();

        ResponseEntity<Blog> expected = ResponseEntity.ok().body(blog);

        when(blogService.get((long) 1)).thenReturn(blog);

        ResponseEntity<Blog> actual = blogController.read((long) 1);

        Assertions.assertEquals(expected, actual);

    }




    public Blog getBlog() {
        Blog blog = new Blog();
        blog.setId(1);
        blog.setImg("test");
        blog.setBody("test");
        blog.setTitle("test");
        return blog;
    }

}