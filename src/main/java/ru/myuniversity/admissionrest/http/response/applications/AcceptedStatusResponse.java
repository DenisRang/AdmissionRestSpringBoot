package ru.myuniversity.admissionrest.http.response.applications;

import java.util.Date;

public class AcceptedStatusResponse extends ApplicationStatusResponse {
    private String comment;
    private int interviewer;

    public AcceptedStatusResponse(Date changed, String comment, int interviewer) {
        super(changed);
        this.comment = comment;
        this.interviewer = interviewer;
    }
}
