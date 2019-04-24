package ru.myuniversity.admissionrest.model.test;

/**
 * This attempt specification contains information about an attempt to solve
 * a {@link ru.myuniversity.admissionrest.model.question.TextQuestion}.
 */
public class TextQuestionAttempt extends QuestionAttempt {
    private String answer;

    public TextQuestionAttempt(int questionId, String answer) {
        super(questionId);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
