package ru.myuniversity.admissionrest.http.request.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;

/**
 * A enum representing a name for an application status.
 * User for performing filtering when requesting a list of applications as a query parameter.
 */
public enum ApplicationStatusName {
    @JsonProperty("initial")
    initial,
    @JsonProperty("review")
    review,
    @JsonProperty("interview")
    interview,
    @JsonProperty("rejected")
    rejected,
    @JsonProperty("accepted")
    accepted;

    public @NonNull
    ApplicationStatus.StringKey toPojoStatus() {
        switch (this) {
            case initial:
                return ApplicationStatus.StringKey.INITIAL;
            case accepted:
                return ApplicationStatus.StringKey.ACCEPTED;
            case rejected:
                return ApplicationStatus.StringKey.REJECTED;
            case review:
                return ApplicationStatus.StringKey.PENDING_REVIEW;
            default:
                return ApplicationStatus.StringKey.PENDING_INTERVIEW;
        }
    }
}
