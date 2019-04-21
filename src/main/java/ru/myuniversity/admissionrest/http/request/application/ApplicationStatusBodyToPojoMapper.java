package ru.myuniversity.admissionrest.http.request.application;

import ru.myuniversity.admissionrest.model.applications.AcceptedStatus;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;
import ru.myuniversity.admissionrest.model.applications.PendingInterviewStatus;
import ru.myuniversity.admissionrest.model.applications.RejectedStatus;

public class ApplicationStatusBodyToPojoMapper implements ApplicationStatusBodyVisitor {
    private ApplicationStatus result;

    public ApplicationStatus getResult() {
        return result;
    }

    @Override
    public void visit(AcceptedStatusBody acceptedStatusBody) {
        result = new AcceptedStatus(acceptedStatusBody.getComment(), acceptedStatusBody.getInterviewer());
    }

    @Override
    public void visit(PendingInterviewStatusBody pendingInterviewStatusBody) {
        result = new PendingInterviewStatus(pendingInterviewStatusBody.getDate(), pendingInterviewStatusBody.getInterviewer());
    }

    @Override
    public void visit(RejectedStatusBody rejectedStatusBody) {
        result = new RejectedStatus(rejectedStatusBody.getReason(), rejectedStatusBody.isFixable());
    }

    public static ApplicationStatus map(ApplicationStatusBody statusBody) {
        ApplicationStatusBodyToPojoMapper mapper = new ApplicationStatusBodyToPojoMapper();
        statusBody.accept(mapper);
        return mapper.getResult();
    }
}
