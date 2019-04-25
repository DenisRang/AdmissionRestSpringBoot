package ru.myuniversity.admissionrest.entity.application;

import ru.myuniversity.admissionrest.entity.AnswerVariantEntity;
import ru.myuniversity.admissionrest.entity.question.*;
import ru.myuniversity.admissionrest.entity.user.StaffEntity;
import ru.myuniversity.admissionrest.model.answer.AllAnswerVariants;
import ru.myuniversity.admissionrest.model.answer.AnswerVariant;
import ru.myuniversity.admissionrest.model.applications.*;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.question.RadioQuestion;
import ru.myuniversity.admissionrest.model.question.TextQuestion;
import ru.myuniversity.admissionrest.model.question.VariantsQuestion;

import java.util.ArrayList;
import java.util.List;

public class ApplicationStatusToPojoMapper implements ApplicationStatusEntityVisitor {
    private ApplicationStatus result;

    public ApplicationStatus getResult() {
        return result;
    }

    @Override
    public void visit(InitialStatusEntity initialStatusEntity) {
        result = new InitialStatus(initialStatusEntity.getCreateDateTime());
    }

    @Override
    public void visit(AcceptedStatusEntity acceptedStatusEntity) {
        result = new AcceptedStatus(acceptedStatusEntity.getCreateDateTime(),
                acceptedStatusEntity.getComment(),
                acceptedStatusEntity.getStaff().getId());
    }

    @Override
    public void visit(PendingReviewStatusEntity pendingReviewStatusEntity) {
        result = new PendingReviewStatus(pendingReviewStatusEntity.getCreateDateTime());
    }

    @Override
    public void visit(PendingInterviewStatusEntity pendingInterviewStatusEntity) {
        StaffEntity staffEntity = pendingInterviewStatusEntity.getStaffEntity();
        result = new PendingInterviewStatus(pendingInterviewStatusEntity.getCreateDateTime(),
                pendingInterviewStatusEntity.getDate(),
                staffEntity.getId());
    }

    @Override
    public void visit(RejectedStatusEntity rejectedStatusEntity) {
        result = new RejectedStatus(rejectedStatusEntity.getCreateDateTime(),
                rejectedStatusEntity.getReason(),
                rejectedStatusEntity.isFixable());
    }

    public static ApplicationStatus map(ApplicationStatusEntity applicationStatusEntity) {
        ApplicationStatusToPojoMapper mapper = new ApplicationStatusToPojoMapper();
        applicationStatusEntity.accept(mapper);
        return mapper.getResult();
    }
}
