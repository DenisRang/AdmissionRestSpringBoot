package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;
import ru.myuniversity.admissionrest.entity.ProgramEntity;
import ru.myuniversity.admissionrest.entity.user.StaffEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "accepted_status")
public class AcceptedStatusEntity extends ApplicationStatusEntity {

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @Column(name = "comment")
    private String comment;

    public AcceptedStatusEntity(ApplicationEntity application, Date createDateTime) {
        super(application, createDateTime);
    }

    public AcceptedStatusEntity(ApplicationEntity application, Date createDateTime, StaffEntity staff, String comment) {
        super(application, createDateTime);
        this.staff = staff;
        this.comment = comment;
    }

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AcceptedStatusEntity{" +
                "staff=" + staff +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public void accept(ApplicationStatusEntityVisitor visitor) {
        visitor.visit(this);
    }
}
