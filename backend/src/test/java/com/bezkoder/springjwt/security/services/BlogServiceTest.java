package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.exception.BlogNotFoundException;
import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.repository.BlogRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class BlogServiceTest {


    @Mock
    private BlogRepository blogRepository;
    private AutoCloseable autoCloseable;
    private BlogService blogService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        blogService = new BlogService(blogRepository);
    }

    @AfterEach()
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    void create() {

        Blog blog = new Blog("test", "test", "test");
        blog.setId(1);

        blogService.create(blog);

        ArgumentCaptor<Blog> blogArgumentCaptor = ArgumentCaptor.forClass(Blog.class);

        verify(blogRepository).save(blogArgumentCaptor.capture());


        Blog capturedBlog = blogArgumentCaptor.getValue();

        assertThat(capturedBlog).isEqualTo(blog);

    }

    @Test
    void read() {
        blogService.read();
        verify(blogRepository).findAll();
    }


    @Test
    void getNonExistentBlog() {
        Blog blog = new Blog();

        given(blogRepository.getBlogById(blog.getId())).
                willReturn(null);
        assertThatThrownBy(() -> blogService.get(blog.getId()))
                .isInstanceOf(BlogNotFoundException.class)
                .hasMessageContaining("Blog with id: " + blog.getId() + " is not found!");
        verify(blogRepository, never()).save(any());
    }

    @Test
    void getNonExistentBlog2() {
        Blog blog = new Blog();

        given(blogRepository.findBlogById(blog.getId())).
                willReturn(null);
        assertThatThrownBy(() -> blogService.findBlogById(blog.getId()))
                .isInstanceOf(BlogNotFoundException.class)
                .hasMessageContaining("Blog with id " + blog.getId() + " was not found!");

        verify(blogRepository, never()).save(any());
    }


    @Test
    void update() {

        Blog blog = new Blog("test", "test", "test");
        blog.setId(1);

        blogService.update(blog);

        ArgumentCaptor<Blog> blogArgumentCaptor = ArgumentCaptor.forClass(Blog.class);

        verify(blogRepository).save(blogArgumentCaptor.capture());


        Blog capturedBlog = blogArgumentCaptor.getValue();

        assertThat(capturedBlog).isEqualTo(blog);
    }

    @Test
    void delete() throws IOException {
//
//        Blog blog = new Blog("test", "test", "test");
//        blog.setId(1);
//
//        blogService.delete(blog.getId());
//
//        ArgumentCaptor<Blog> blogArgumentCaptor = ArgumentCaptor.forClass(Blog.class);
//
//        verify(blogRepository).delete(blogArgumentCaptor.capture());
//
//
//        Blog capturedBlog = blogArgumentCaptor.getValue();
//
//        assertThat(capturedBlog).isEqualTo(blog);

    }

}