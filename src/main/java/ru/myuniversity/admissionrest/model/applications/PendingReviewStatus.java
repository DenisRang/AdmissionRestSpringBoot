package ru.myuniversity.admissionrest.model.applications;

import java.util.Date;

/**
 * A candidate has filled all the fields, but the manager didn't review the application yet.
 */
public class PendingReviewStatus extends ApplicationStatus {

    public PendingReviewStatus(Date changed) {
        super(changed);
    }

    @Override
    public void accept(ApplicationStatusVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public StringKey getKey() {
        return StringKey.PENDING_REVIEW;
    }
}
