package ru.myuniversity.admissionrest.http.response.users;

import ru.myuniversity.admissionrest.http.common.UserRole;
import ru.myuniversity.admissionrest.model.users.User;

public class UserResponse {
    private int id;
    private String name;
    private String email;
    private UserRole role;

    public UserResponse(int id, String name, String email, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public UserResponse(User pojoUser) {
        this.id = pojoUser.getId();
        this.name = pojoUser.getName();
        this.email = pojoUser.getEmail();
        this.role = UserRole.map(pojoUser.getRole());
    }
}
