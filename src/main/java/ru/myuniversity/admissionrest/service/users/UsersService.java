package ru.myuniversity.admissionrest.service.users;

import org.springframework.lang.Nullable;
import ru.myuniversity.admissionrest.model.users.User;

import java.util.List;

public interface UsersService {
    List<User> getUsers(@Nullable String name, @Nullable User.Role role);
    void createUser(String name, User.Role role, String email);
    User getUser(int id);
}
