package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;
import ru.myuniversity.admissionrest.entity.user.StaffEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pending_interview_status")
public class PendingInterviewStatusEntity extends ApplicationStatusEntity {

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private StaffEntity staffEntity;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;


    public PendingInterviewStatusEntity(ApplicationEntity application, Date createDateTime, StaffEntity staffEntity, Date date) {
        super(application, createDateTime);
        this.staffEntity = staffEntity;
        this.date = date;
    }

    public StaffEntity getStaffEntity() {
        return staffEntity;
    }

    public void setStaffEntity(StaffEntity staffEntity) {
        this.staffEntity = staffEntity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PendingInterviewStatusEntity{" +
                "staffEntity=" + staffEntity +
                ", date=" + date +
                '}';
    }

    @Override
    public void accept(ApplicationStatusEntityVisitor visitor) {
        visitor.visit(this);
    }
}
