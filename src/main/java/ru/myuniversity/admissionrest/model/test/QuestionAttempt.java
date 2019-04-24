package ru.myuniversity.admissionrest.model.test;

public abstract class QuestionAttempt {
    private int questionId;

    public QuestionAttempt(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }
}
