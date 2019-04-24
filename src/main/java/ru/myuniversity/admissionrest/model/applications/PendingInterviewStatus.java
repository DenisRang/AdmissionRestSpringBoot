package ru.myuniversity.admissionrest.model.applications;

import java.util.Date;

/**
 * A manager has appointed an interview for the application's candidate.
 */
public class PendingInterviewStatus extends ApplicationStatus {
    /**
     * Date when the interview shall take place.
     */
    private Date date;

    /**
     * Identifier of an interviewer who is to conduct the interview.
     */
    private int interviewer;

    public PendingInterviewStatus(Date changed, Date date, int interviewer) {
        super(changed);
        this.date = date;
        this.interviewer = interviewer;
    }

    public PendingInterviewStatus(Date date, int interviewer) {
        this.date = date;
        this.interviewer = interviewer;
    }

    public Date getDate() {
        return date;
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
        return StringKey.PENDING_INTERVIEW;
    }
}
