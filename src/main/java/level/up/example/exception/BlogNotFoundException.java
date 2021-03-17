package level.up.example.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String s) {
        super(s);
    }
}
