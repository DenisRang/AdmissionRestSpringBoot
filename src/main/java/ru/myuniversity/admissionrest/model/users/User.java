package ru.myuniversity.admissionrest.model.users;

public class User {
    public enum Role {
        CANDIDATE,
        MANAGER,
        UNIVERSITY_STAFF
    }

    private int id;
    private String name;
    private String email;
    private Role role;

    public User(int id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User(String name, String email, Role role) {
        this(0, name, email, role);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
