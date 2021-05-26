package level.up.example.module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Test
    void getId() {
        long id = 1;
        assertEquals(1, id);
    }

    @Test
    void getTitle() {
        String title = "league";
        Blog blog = new Blog("league", "test", "test.png");
        assertNotNull(blog);
        assertEquals(title, blog.getTitle());
    }

    @Test
    void setTitle() {
        Blog blog = new Blog("league", "test", "test1.png");
        blog.setTitle("apex");
        assertNotNull(blog);
        assertEquals("apex", blog.getTitle());
    }


    @Test
    void getImg() {
        String img = "test.png";
        Blog blog = new Blog("league", "test", "test.png");
        assertNotNull(blog);
        assertEquals(img, blog.getImg());
    }

    @Test
    void setImg() {
        Blog blog = new Blog("league", "test", "test.png");
        blog.setImg("apex.png");
        assertNotNull(blog);
        assertEquals("apex.png", blog.getImg());
    }

    @Test
    void getBody() {
        String body = "info";
        Blog blog = new Blog("league", "info", "test.png");
        assertNotNull(blog);
        assertEquals(body, blog.getBody());
    }

    @Test
    void setBody() {
        Blog blog = new Blog("league", "info", "test.png");
        blog.setBody("test");
        assertNotNull(blog);
        assertEquals("test", blog.getBody());
    }
}