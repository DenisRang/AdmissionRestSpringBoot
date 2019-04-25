package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "rejected_status")
public class RejectedStatusEntity extends ApplicationStatusEntity {

    @Column(name = "reason")
    private String reason;

    @Column(name = "fixable")
    private boolean fixable;


    public RejectedStatusEntity(ApplicationEntity application, LocalDateTime createDateTime) {
        super(application, createDateTime);
    }

    public RejectedStatusEntity(ApplicationEntity application, LocalDateTime createDateTime, String reason, boolean fixable) {
        super(application, createDateTime);
        this.reason = reason;
        this.fixable = fixable;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isFixable() {
        return fixable;
    }

    public void setFixable(boolean fixable) {
        this.fixable = fixable;
    }

    @Override
    public String toString() {
        return "RejectedStatusEntity{" +
                "reason='" + reason + '\'' +
                ", fixable=" + fixable +
                '}';
    }
}
