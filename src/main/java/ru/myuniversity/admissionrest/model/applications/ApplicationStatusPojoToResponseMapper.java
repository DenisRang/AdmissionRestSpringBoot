package ru.myuniversity.admissionrest.model.applications;

import ru.myuniversity.admissionrest.http.response.applications.*;

public class ApplicationStatusPojoToResponseMapper implements ApplicationStatusVisitor {
    private ApplicationStatusResponse result;

    public ApplicationStatusResponse getResult() {
        return result;
    }

    @Override
    public void visit(AcceptedStatus acceptedStatus) {
        result = new AcceptedStatusResponse(
                acceptedStatus.getChanged(),
                acceptedStatus.getComment(),
                acceptedStatus.getInterviewer()
        );
    }

    @Override
    public void visit(InitialStatus initialStatus) {
        result = new InitialStatusResponse(initialStatus.getChanged());
    }

    @Override
    public void visit(PendingInterviewStatus interviewStatus) {
        result = new PendingInterviewStatusResponse(
                interviewStatus.getChanged(),
                interviewStatus.getDate(),
                interviewStatus.getInterviewer()
        );
    }

    @Override
    public void visit(PendingReviewStatus reviewStatus) {
        result = new PendingReviewStatusResponse(reviewStatus.getChanged());
    }

    @Override
    public void visit(RejectedStatus rejectedStatus) {
        result = new RejectedStatusResponse(
                rejectedStatus.getChanged(),
                rejectedStatus.getReason(),
                rejectedStatus.isFixable()
        );
    }

    public static ApplicationStatusResponse map(ApplicationStatus status) {
        ApplicationStatusPojoToResponseMapper mapper = new ApplicationStatusPojoToResponseMapper();
        status.accept(mapper);
        return mapper.getResult();
    }
}
