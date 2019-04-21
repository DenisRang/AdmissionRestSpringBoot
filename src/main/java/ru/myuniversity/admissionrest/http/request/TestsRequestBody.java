package ru.myuniversity.admissionrest.http.request;

import org.springframework.lang.NonNull;

/**
 * A data structure for request HTTP body in /tests PUT and POST requests.
 */
public class TestsRequestBody {
    /**
     * A title for {@link ru.myuniversity.admissionrest.model.test.Test} being created or modified.
     */
    @NonNull
    private String title;

    public String getTitle() {
        return title;
    }
}
