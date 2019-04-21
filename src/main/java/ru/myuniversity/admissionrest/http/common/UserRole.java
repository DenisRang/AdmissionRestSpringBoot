package ru.myuniversity.admissionrest.http.common;

import org.springframework.lang.NonNull;
import ru.myuniversity.admissionrest.model.users.User;

/**
 * User role types that are allowed to be sent as parameters.
 */
public enum UserRole {
    manager,
    staff,
    candidate;

    public @NonNull
    User.Role pojoRole() {
        switch (this) {
            case candidate:
                return User.Role.CANDIDATE;
            case manager:
                return User.Role.MANAGER;
            default:
                return User.Role.UNIVERSITY_STAFF;
        }
    }

    public static @NonNull
    UserRole map(User.Role pojoRole) {
        switch (pojoRole) {
            case CANDIDATE:
                return candidate;
            case UNIVERSITY_STAFF:
                return staff;
            default:
                return manager;
        }
    }
}
