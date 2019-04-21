package ru.myuniversity.admissionrest.http.response.applications;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Date;

@JsonTypeName("interview")
public class PendingInterviewStatusResponse extends ApplicationStatusResponse {
    private Date date;
    private int interviewer;

    public PendingInterviewStatusResponse(Date changed, Date date, int interviewer) {
        super(changed);
        this.date = date;
        this.interviewer = interviewer;
    }
}
