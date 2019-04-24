package ru.myuniversity.admissionrest.model.applications;

import java.util.Date;

/**
 * Base class for all application statuses.
 */
public abstract class ApplicationStatus {
    public enum StringKey {
        ACCEPTED,
        REJECTED,
        INITIAL,
        PENDING_INTERVIEW,
        PENDING_REVIEW
    }
    /**
     * Last time status was changed.
     */
    private Date changed;

    /**
     * Initializer for creation a status instance from existing data, e.g. a database.
     * @param changed date the status was set.
     */
    public ApplicationStatus(Date changed) {
        this.changed = changed;
    }

    /**
     * Initializer for creation a new status instance.
     * Initializes its date to current date.
     */
    public ApplicationStatus() {
        this.changed = new Date();
    }

    public Date getChanged() {
        return changed;
    }

    public abstract void accept(ApplicationStatusVisitor visitor);

    public abstract StringKey getKey();
}
