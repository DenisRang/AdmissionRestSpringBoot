package ru.myuniversity.admissionrest.service.users;

import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.model.users.User;

import java.util.Collections;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public List<User> getUsers(String name, User.Role role) {
        // TODO: Replace with repository implementation
        return Collections.singletonList(new User(1, "Bulat Khabirov", "b.khabirov@innopolis.ru", User.Role.CANDIDATE));
    }

    @Override
    public void createUser(String name, User.Role role, String email) {
        // TODO: Repository
    }

    @Override
    public User getUser(int id) {
        // TODO: repository
        return new User(id, "Bulat Khabirov", "b.khabirov@innopolis.ru", User.Role.CANDIDATE);
    }
}
