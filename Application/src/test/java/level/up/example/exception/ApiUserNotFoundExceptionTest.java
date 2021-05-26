package level.up.example.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNotFoundExceptionTest {

    @Test
    void userNotFound() {
        String message = "user not found!";
        UserNotFoundException UserNotFoundException = new UserNotFoundException(message);
        assertNotNull(UserNotFoundException);
        assertEquals(UserNotFoundException, UserNotFoundException);
    }


}