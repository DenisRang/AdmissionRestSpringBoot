package ru.myuniversity.admissionrest.http.response.applications;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AcceptedStatusResponse.class, name = "accepted"),
        @JsonSubTypes.Type(value = InitialStatusResponse.class, name = "initial"),
        @JsonSubTypes.Type(value = RejectedStatusResponse.class, name = "rejected"),
        @JsonSubTypes.Type(value = PendingInterviewStatusResponse.class, name = "interview"),
        @JsonSubTypes.Type(value = PendingReviewStatusResponse.class, name = "review")
})
public abstract class ApplicationStatusResponse {
    private Date changed;

    public ApplicationStatusResponse(Date changed) {
        this.changed = changed;
    }
}
