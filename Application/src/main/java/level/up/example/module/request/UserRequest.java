package level.up.example.module.request;

import lombok.Data;

@Data
public class UserRequest {
    public String email;
    public String password;
    public String firstName;
    public String lastName;
}
