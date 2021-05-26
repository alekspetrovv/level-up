package level.up.example.module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getEmail() {
        String email = "email";
        User user = new User("email", "test", "test", "test");
        assertNotNull(user);
        assertEquals(email, user.getEmail());
    }

    @Test
    void setEmail() {
        User user = new User("email", "test", "test", "test");
        user.setEmail("email2");
        assertNotNull(user);
        assertEquals("email2", user.getEmail());
    }

    @Test
    void getId() {
        long id = 1;
        User user = new User();
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void createUser() {
        new User();
    }

    @Test
    void setId() {
        long id = 1;
        User user = new User();
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void getPassword() {
        String password = "password";
        User user = new User("email", "password", "test", "test");
        assertNotNull(user);
        assertEquals(password, user.getPassword());

    }

    @Test
    void setPassword() {
        User user = new User("email", "test", "test", "test");
        user.setPassword("password");
        assertNotNull(user);
        assertEquals("password", user.getPassword());
    }

    @Test
    void getFirstName() {
        String firstName = "alex";
        User user = new User("email", "test", "alex", "test");
        assertNotNull(user);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    void setFirstName() {
        User user = new User("email", "test", "alex", "test");
        user.setFirstName("george");
        assertNotNull(user);
        assertEquals("george", user.getFirstName());
    }

    @Test
    void getLastName() {
        String secondName = "petrov";
        User user = new User("email", "test", "alex", "petrov");
        assertNotNull(user);
        assertEquals(secondName, user.getLastName());

    }

    @Test
    void setLastName() {
        User user = new User("email", "test", "alex", "test");
        user.setLastName("petrov");
        assertNotNull(user);
        assertEquals("petrov", user.getLastName());

    }
}