package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "application_status")
public class ApplicationStatusEntity {
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
    private LocalDateTime createDateTime;

    public ApplicationStatusEntity(ApplicationEntity application, LocalDateTime createDateTime) {
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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
