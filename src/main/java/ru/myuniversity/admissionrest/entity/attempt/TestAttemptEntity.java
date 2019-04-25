package ru.myuniversity.admissionrest.entity.attempt;


import ru.myuniversity.admissionrest.entity.TestEntity;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;

import javax.persistence.*;

@Entity
@Table(name = "test_attempt")
public abstract class TestAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidate;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "test_id")
    private TestEntity test;

    @Column(name = "grade")
    private double grade;

    public TestAttemptEntity() {
    }

    public TestAttemptEntity(CandidateEntity candidate, TestEntity test, double grade) {
        this.candidate = candidate;
        this.test = test;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CandidateEntity getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateEntity candidate) {
        this.candidate = candidate;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "TestAttemptEntity{" +
                "id=" + id +
                ", candidate=" + candidate +
                ", test=" + test +
                ", grade=" + grade +
                '}';
    }
}
