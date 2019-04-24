package ru.myuniversity.admissionrest.http.response.tests;

import ru.myuniversity.admissionrest.model.test.TextQuestionAttempt;

public class TextQuestionAttemptResponse extends QuestionAttemptResponse {
    private String answer;

    public TextQuestionAttemptResponse(TextQuestionAttempt pojoAttempt) {
        super(pojoAttempt);
        answer = pojoAttempt.getAnswer();
    }
}
