package ru.myuniversity.admissionrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.myuniversity.admissionrest.http.common.UserRole;
import ru.myuniversity.admissionrest.http.request.users.NewUserRequestBody;
import ru.myuniversity.admissionrest.http.response.users.UserResponse;
import ru.myuniversity.admissionrest.model.users.User;
import ru.myuniversity.admissionrest.service.users.UsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UsersRestController {
    private UsersService usersService;

    @Autowired
    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(@RequestParam @Nullable String name, @RequestParam @Nullable UserRole role) {
        User.Role pojoRole = null;
        if (role != null) pojoRole = role.pojoRole();

        return usersService.getUsers(name, pojoRole).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{userId}")
    public UserResponse getUser(@PathVariable int userId) {
        return new UserResponse(usersService.getUser(userId));
    }

    @GetMapping("/users/me")
    public UserResponse getMe(@RequestHeader("Authorization") String token) {
        return new UserResponse(usersService.getUser(token));
    }

    @PostMapping("/users/new")
    public void createUser(@RequestBody NewUserRequestBody userRequestBody) {
        usersService.createUser(
                userRequestBody.getName(),
                userRequestBody.getRole().pojoRole(),
                userRequestBody.getEmail()
        );
    }
}
