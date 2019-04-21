package ru.myuniversity.admissionrest.http.request.application;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Date;

@JsonTypeName("interview")
public class PendingInterviewStatusBody extends ApplicationStatusBody {
    private Date date;
    private int interviewer;

    public Date getDate() {
        return date;
    }

    public int getInterviewer() {
        return interviewer;
    }

    @Override
    public void accept(ApplicationStatusBodyVisitor visitor) {
        visitor.visit(this);
    }
}
