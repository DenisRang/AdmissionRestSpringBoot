package ru.myuniversity.admissionrest.model.applications;

import java.util.Date;

/**
 * Initial status of the application. The candidate has not yet filled all the required data.
 */
public class InitialStatus extends ApplicationStatus {
    public InitialStatus(Date changed) {
        super(changed);
    }

    @Override
    public void accept(ApplicationStatusVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public StringKey getKey() {
        return StringKey.INITIAL;
    }
}
