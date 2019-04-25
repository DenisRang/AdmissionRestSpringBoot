package ru.myuniversity.admissionrest.http.response.tests;

import ru.myuniversity.admissionrest.model.test.Attempt;
import ru.myuniversity.admissionrest.model.test.PojoQuestionAttemptToResponseMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TestAttemptResponse {
    private int testId;
    private int id;
    private List<QuestionAttemptResponse> questionAttempts;

    public TestAttemptResponse(Attempt pojoAttempt) {
        testId = pojoAttempt.getTestId();
        id = pojoAttempt.getId();
        questionAttempts = pojoAttempt.getQuestionAttempts().stream().map(PojoQuestionAttemptToResponseMapper::map)
                .collect(Collectors.toList());
    }
}
