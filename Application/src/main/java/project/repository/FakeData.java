package project.repository;

import project.module.Admin;
import project.module.Customer;
import project.module.User;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

    private final List<User> users = new ArrayList<>();


    public FakeData() {


        User customer1 = new Customer("customer1", "test", "Test1", "Test", "test");
        User customer2 = new Customer("customer2", "test", "Test2", "Test", "test");
        User customer3 = new Customer("customer3", "test", "Test3", "Test", "test");


        User admin1 = new Admin("admin1", "test", "Test4", "Test", "test");
        User admin2 = new Admin("admin2", "test", "Test5", "Test", "test");
        User admin3 = new Admin("admin3", "test", "Test6", "Test", "test");

        users.add(customer1);
        users.add(customer2);
        users.add(customer3);
        users.add(admin1);
        users.add(admin2);
        users.add(admin3);
    }


    public User get(String uname) {
        for (User user : users) {
            if (user.getUserName().equals(uname))
                return user;
        }
        return null;
    }

    public boolean add(User u) {
        if (get(u.getUserName()) != null) {
            return false;
        }
        getUsers().add(u);
        return true;
    }


    public boolean update(User u) {
        User old = get(u.getUserName());
        if (old == null) {
            return false;
        }
        old.setFirstName(u.getFirstName());
        old.setLastName(u.getLastName());
        return true;
    }

    public boolean delete(String username) {
        User user = get(username);
        if (user == null) {
            return false;
        }
        users.remove(user);
        return true;
    }


    public List<User> getUsers() {
        return users;
    }
}

