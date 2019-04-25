package ru.myuniversity.admissionrest.model.applications;

import java.util.Date;

/**
 * An application status indicating that the application was rejected by either a manager
 * or a member of university staff.
 */
public class RejectedStatus extends ApplicationStatus {
    /**
     * A human readable reason for rejection.
     */
    private String reason;

    /**
     * Whether a candidate can resubmit this application by resubmitting the documents.
     */
    private boolean fixable;

    public RejectedStatus(Date changed, String reason, boolean fixable) {
        super(changed);
        this.reason = reason;
        this.fixable = fixable;
    }

    public RejectedStatus(String reason, boolean fixable) {
        this.reason = reason;
        this.fixable = fixable;
    }

    public String getReason() {
        return reason;
    }

    public boolean isFixable() {
        return fixable;
    }

    @Override
    public void accept(ApplicationStatusVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public StringKey getKey() {
        return StringKey.REJECTED;
    }
}
