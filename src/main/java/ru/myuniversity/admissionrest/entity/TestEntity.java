package ru.myuniversity.admissionrest.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    public TestEntity() {
    }

    public TestEntity(String title) {
        this.title = title;
    }

    public TestEntity(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
