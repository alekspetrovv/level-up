package project.module;

public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String userName, String password, String firstName, String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        return this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User {" +
                "username= " + getUserName() +
                ",password= '" + getPassword() + '\'' +
                ",First Name= " + getFirstName() +
                ",Last Name= " + getLastName() +
                ",Email= " + getEmail() +
                '}';
    }

}
