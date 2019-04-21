package ru.myuniversity.admissionrest.http.response.applications;

import java.util.Date;

public class PendingReviewStatusResponse extends ApplicationStatusResponse {
    public PendingReviewStatusResponse(Date changed) {
        super(changed);
    }
}
