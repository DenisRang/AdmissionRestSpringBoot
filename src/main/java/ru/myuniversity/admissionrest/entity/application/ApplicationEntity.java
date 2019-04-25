package ru.myuniversity.admissionrest.entity.application;

import ru.myuniversity.admissionrest.entity.ProgramEntity;
import ru.myuniversity.admissionrest.entity.attempt.TestAttemptEntity;
import ru.myuniversity.admissionrest.entity.question.QuestionEntity;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "program_id")
    private ProgramEntity program;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private CandidateEntity candidateEntity;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private ApplicationStatusEntity status;

    public ApplicationEntity(ProgramEntity program, CandidateEntity candidateEntity, ApplicationStatusEntity status) {
        this.program = program;
        this.candidateEntity = candidateEntity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "id=" + id +
                ", program=" + program +
                ", candidateEntity=" + candidateEntity +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProgramEntity getProgram() {
        return program;
    }

    public void setProgram(ProgramEntity program) {
        this.program = program;
    }

    public CandidateEntity getCandidateEntity() {
        return candidateEntity;
    }

    public void setCandidateEntity(CandidateEntity candidateEntity) {
        this.candidateEntity = candidateEntity;
    }

    public ApplicationStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatusEntity status) {
        this.status = status;
    }
}
