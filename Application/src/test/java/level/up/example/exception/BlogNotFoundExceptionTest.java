package level.up.example.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlogNotFoundExceptionTest {

    @Test
    void blogNotFound() {
        String message = "blog not found!";
        BlogNotFoundException blogNotFoundException = new BlogNotFoundException(message);
        assertNotNull(blogNotFoundException);
        assertEquals(blogNotFoundException, blogNotFoundException);
    }

}