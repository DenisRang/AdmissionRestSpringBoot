package ru.myuniversity.admissionrest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "program")
public class ProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "program_test",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private List<TestEntity> tests;

    public ProgramEntity() {
    }

    public ProgramEntity(String title, List<TestEntity> tests) {
        this.title = title;
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgramEntity)) return false;
        return id != 0 && id==(((ProgramEntity) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ProgramEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tests=" + tests +
                '}';
    }

    public void addTest(TestEntity test) {
        tests.add(test);
        test.getPrograms().add(this);
    }

    public void removeTest(TestEntity test) {
        tests.remove(test);
        test.getPrograms().remove(this);
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

    public List<TestEntity> getTests() {
        return tests;
    }

    public void setTests(List<TestEntity> tests) {
        this.tests = tests;
    }

}
