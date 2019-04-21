package ru.myuniversity.admissionrest.http.request.users;

import ru.myuniversity.admissionrest.http.common.UserRole;

public class NewUserRequestBody {
    /**
     * Full name of a user to create.
     */
    private String name;

    /**
     * Email of a user to create.
     */
    private String email;

    /**
     * Role of a user to create.
     */
    private UserRole role;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }
}
