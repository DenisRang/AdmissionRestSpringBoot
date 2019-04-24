package ru.myuniversity.admissionrest.model.test;

import org.springframework.lang.NonNull;

public class Test {
    @NonNull
    private int id;
    @NonNull
    private String title;

    public Test() {
        // required
    }

    public Test(String title) {
        this.title = title;
    }

    public Test(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}