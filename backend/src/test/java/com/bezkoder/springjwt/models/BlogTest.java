package com.bezkoder.springjwt.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Test
    void getImg() {
        String img = "nav.png";
        Blog blog = new Blog("league", "test", img);
        assertNotNull(blog);
        assertEquals("/img/blogs/0/nav.png", blog.getImg());
    }

    @Test
    void createBlog(){
        new Blog();
    }

    @Test
    void getId() {
        long id = 1;
        Blog blog = new Blog();
        blog.setId(id);
        assertEquals(id, blog.getId());
    }

    @Test
    void getTitle() {
        String title = "league";
        Blog blog = new Blog("league", "test", "test.png");
        assertNotNull(blog);
        assertEquals(title, blog.getTitle());
    }

    @Test
    void getBody() {
        String body = "info";
        Blog blog = new Blog("league", "info", "test.png");
        assertNotNull(blog);
        assertEquals(body, blog.getBody());
    }

    @Test
    void setId() {
        long id = 1;
        Blog blog = new Blog();
        blog.setId(id);
        assertEquals(id, blog.getId());
    }

    @Test
    void setTitle() {
        Blog blog = new Blog("league", "test", "test1.png");
        blog.setTitle("apex");
        assertNotNull(blog);
        assertEquals("apex", blog.getTitle());

    }

    @Test
    void setBody() {
        Blog blog = new Blog("league", "info", "test.png");
        blog.setBody("test");
        assertNotNull(blog);
        assertEquals("test", blog.getBody());
    }

    @Test
    void setImg() {
        String img = "nav.png";
        Blog blog = new Blog("league", "test", img);
        String updateImg = "blog.png";
        blog.setImg(updateImg);
        assertNotNull(blog);
        assertEquals("/img/blogs/0/blog.png", blog.getImg());
    }
}