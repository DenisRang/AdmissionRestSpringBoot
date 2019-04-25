package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;
import ru.myuniversity.admissionrest.entity.user.StaffEntity;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatusVisitor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pending_interview_status")
public class PendingReviewStatusEntity extends ApplicationStatusEntity {

    public PendingReviewStatusEntity(ApplicationEntity application, Date createDateTime) {
        super(application, createDateTime);
    }

    @Override
    public void accept(ApplicationStatusEntityVisitor visitor) {
        visitor.visit(this);
    }
}
