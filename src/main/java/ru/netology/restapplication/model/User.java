package ru.netology.restapplication.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {
    @NotBlank(message = "User name is empty!")
    @Size(min = 2, max = 30, message = "User name is longer or shorter than expected!")
    String user;
    @NotBlank(message = "Password is empty")
    String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return getUser().equals(user1.getUser()) && getPassword().equals(user1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}
