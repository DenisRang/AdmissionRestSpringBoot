package ru.myuniversity.admissionrest.http.request.application;

/**
 * A visitor for children of {@link ApplicationStatusBody}.
 * May be used for mapping.
 */
public interface ApplicationStatusBodyVisitor {
    void visit(AcceptedStatusBody acceptedStatusBody);
    void visit(PendingInterviewStatusBody pendingInterviewStatusBody);
    void visit(RejectedStatusBody rejectedStatusBody);
}
