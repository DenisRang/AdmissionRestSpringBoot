package ru.myuniversity.admissionrest.model.test;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * An Attempt contains information about Candidate's attempt on solving a {@link Test}.
 * I.e. given answers to some or all of the questions and a grade (if test is finished).
 */
public class Attempt {
    @Nullable
    private Double grade;

    @NonNull
    private List<QuestionAttempt> questionAttempts;
    private int id;
    private int testId;

    public Attempt(int id, int testId) {
        this.id = id;
        this.testId = testId;
        questionAttempts = Collections.emptyList();
        grade = null;
    }

    public int getId() {
        return id;
    }

    public int getTestId() {
        return testId;
    }

    public void setGrade(@Nullable Double grade) {
        this.grade = grade;
    }

    public void setQuestionAttempts(List<QuestionAttempt> questionAttempts) {
        this.questionAttempts = questionAttempts;
    }

    @Nullable
    public Double getGrade() {
        return grade;
    }

    public List<QuestionAttempt> getQuestionAttempts() {
        return questionAttempts;
    }
}
