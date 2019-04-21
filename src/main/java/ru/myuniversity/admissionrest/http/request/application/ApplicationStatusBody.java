package ru.myuniversity.admissionrest.http.request.application;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AcceptedStatusBody.class, name = "accepted"),
        @JsonSubTypes.Type(value = PendingInterviewStatusBody.class, name = "interview"),
        @JsonSubTypes.Type(value = RejectedStatusBody.class, name = "rejected")
})
public abstract class ApplicationStatusBody {
    public abstract void accept(ApplicationStatusBodyVisitor visitor);
}
