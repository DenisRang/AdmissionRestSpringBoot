package ru.myuniversity.admissionrest.model.applications;

/**
 * A candidate has filled all the fields, but the manager didn't review the application yet.
 */
public class PendingReviewStatus extends ApplicationStatus {
    @Override
    public void accept(ApplicationStatusVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public StringKey getKey() {
        return StringKey.PENDING_REVIEW;
    }
}
