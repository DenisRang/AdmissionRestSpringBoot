package ru.myuniversity.admissionrest.http.response.applications;

import ru.myuniversity.admissionrest.http.response.tests.TestAttemptShortResponse;
import ru.myuniversity.admissionrest.http.response.users.UserResponse;

import java.util.List;

public class ApplicationResponse {
    private int id;
    private UserResponse candidate;
    private List<TestAttemptShortResponse> testAttempts;
    private List<ApplicationStatusResponse> history;

    public ApplicationResponse(int id, UserResponse candidate, List<TestAttemptShortResponse> testAttempts, List<ApplicationStatusResponse> history) {
        this.id = id;
        this.candidate = candidate;
        this.testAttempts = testAttempts;
        this.history = history;
    }
}
