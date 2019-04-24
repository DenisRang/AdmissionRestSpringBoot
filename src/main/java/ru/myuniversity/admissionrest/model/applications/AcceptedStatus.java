package ru.myuniversity.admissionrest.model.applications;

import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * A status indicating that an application was successfully accepted.
 */
public class AcceptedStatus extends ApplicationStatus {
    /**
     * Interviewer's commentary after the interview.
     */
    @Nullable
    private String comment;
    private int interviewer;

    public AcceptedStatus(Date changed, @Nullable String comment, int interviewer) {
        super(changed);
        this.comment = comment;
        this.interviewer = interviewer;
    }

    /**
     * A constructor for creating a new instance of {@link AcceptedStatus}.
     * Sets the changed date to current date.
     * @param comment interviewer's commentary.
     * @param interviewer interviewer id.
     */
    public AcceptedStatus(@Nullable String comment, int interviewer) {
        super();
        this.comment = comment;
        this.interviewer = interviewer;
    }

    @Nullable
    public String getComment() {
        return comment;
    }

    public int getInterviewer() {
        return interviewer;
    }

    @Override
    public void accept(ApplicationStatusVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public StringKey getKey() {
        return StringKey.ACCEPTED;
    }
}
