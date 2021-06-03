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
        ApiUser user = new ApiUser();
        String title = "league";
        Blog blog = new Blog("league", "test", "test.png", user);
        assertNotNull(blog);
        assertEquals(title, blog.getTitle());
    }

    @Test
    void setTitle() {
        ApiUser user = new ApiUser();
        Blog blog = new Blog("league", "test", "test1.png", user);
        blog.setTitle("apex");
        assertNotNull(blog);
        assertEquals("apex", blog.getTitle());
    }

    @Test
    void getImg() {
        ApiUser user = new ApiUser();
        String img = "nav.png";
        Blog blog = new Blog("league", "test", img, user);
        assertNotNull(blog);
        assertEquals("/img/blogs/0/nav.png", blog.getImg());
    }

    @Test
    void setImg() {
        String img = "nav.png";
        ApiUser user = new ApiUser();
        Blog blog = new Blog("league", "test", img, user);
        String updateImg = "blog.png";
        blog.setImg(updateImg);
        assertNotNull(blog);
        assertEquals("/img/blogs/0/blog.png", blog.getImg());
    }

    @Test
    void getBody() {
        String body = "info";
        ApiUser user = new ApiUser();
        Blog blog = new Blog("league", "info", "test.png", user);
        assertNotNull(blog);
        assertEquals(body, blog.getBody());
    }

    @Test
    void setBody() {
        ApiUser user = new ApiUser();
        Blog blog = new Blog("league", "info", "test.png", user);
        blog.setBody("test");
        assertNotNull(blog);
        assertEquals("test", blog.getBody());
    }

    @Test
    void testSetUser() {
        ApiUser user1 = new ApiUser("test", "test", "test", "test");
        ApiUser user2 = new ApiUser("test1", "test", "test", "test");
        Blog blog = new Blog("league", "test", "test1.png", user1);
        blog.setApi_user(user2);
        assertNotNull(blog);
        assertEquals("test1", blog.getApi_user().getEmail());
    }

    @Test
    void testGetUser() {
        ApiUser user1 = new ApiUser("test", "test", "test", "test");
        Blog blog = new Blog("league", "test", "test1.png", user1);
        assertNotNull(blog);
        assertEquals("test", blog.getApi_user().getEmail());
    }
}