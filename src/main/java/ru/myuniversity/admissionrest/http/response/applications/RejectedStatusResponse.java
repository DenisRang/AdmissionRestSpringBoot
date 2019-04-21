package ru.myuniversity.admissionrest.http.response.applications;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Date;

@JsonTypeName("rejected")
public class RejectedStatusResponse extends ApplicationStatusResponse {
    private String reason;
    private boolean fixable;

    public RejectedStatusResponse(Date changed, String reason, boolean fixable) {
        super(changed);
        this.reason = reason;
        this.fixable = fixable;
    }
}
