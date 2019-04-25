package ru.myuniversity.admissionrest.entity.application;

public interface ApplicationStatusEntityVisitor {
    void visit(InitialStatusEntity initialStatusEntity);

    void visit(AcceptedStatusEntity acceptedStatusEntity);

    void visit(PendingReviewStatusEntity pendingReviewStatusEntity);

    void visit(PendingInterviewStatusEntity pendingInterviewStatusEntity);

    void visit(RejectedStatusEntity rejectedStatusEntity);
}
