package ru.myuniversity.admissionrest.http.response.tests;

import org.springframework.lang.Nullable;
import ru.myuniversity.admissionrest.model.test.Attempt;

public class TestAttemptShortResponse {
    private int id;
    private int testId;
    @Nullable
    private Double grade;

    public TestAttemptShortResponse(Attempt pojoAttempt) {
        id = pojoAttempt.getId();
        testId = pojoAttempt.getTestId();
        grade = pojoAttempt.getGrade();
    }
}
