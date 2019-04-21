package ru.myuniversity.admissionrest.model.applications;

public interface ApplicationStatusVisitor {
    void visit(AcceptedStatus acceptedStatus);
    void visit(InitialStatus initialStatus);
    void visit(PendingInterviewStatus interviewStatus);
    void visit(PendingReviewStatus reviewStatus);
    void visit(RejectedStatus rejectedStatus);
}
