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

    @ManyToMany(mappedBy = "tests")
    private List<ProgramEntity> programs = new ArrayList<>();

    public TestEntity() {
    }

    public TestEntity(String title) {
        this.title = title;
    }

    public TestEntity(String title, List<ProgramEntity> programs) {
        this.title = title;
        this.programs = programs;
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

    public List<ProgramEntity> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramEntity> programs) {
        this.programs = programs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity test = (TestEntity) o;
        return Objects.equals(id, test.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", programs=" + programs +
                '}';
    }
}
