package ru.myuniversity.admissionrest.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "test_id")
    private Set<QuestionEntity> questions = new HashSet<>();

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

    public Set<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionEntity> questions) {
        this.questions = questions;
    }

    public void addQuestion(QuestionEntity question) {
        questions.add(question);
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}