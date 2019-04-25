package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatusVisitor;

import javax.persistence.*;
import java.io.DataInputStream;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "application_status")
public abstract class ApplicationStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    private ApplicationEntity application;

    @Column(name = "changed")
    @CreationTimestamp
    private Date createDateTime;

    public ApplicationStatusEntity() {
    }

    public ApplicationStatusEntity(ApplicationEntity application, Date createDateTime) {
        this.application = application;
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return "ApplicationStatusEntity{" +
                "id=" + id +
                ", application=" + application +
                ", createDateTime=" + createDateTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public abstract void accept(ApplicationStatusEntityVisitor visitor);

}
