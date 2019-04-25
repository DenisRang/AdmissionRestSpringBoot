package ru.myuniversity.admissionrest.model.applications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private int id;
    private int programId;
    private int candidateId;
    private List<ApplicationStatus> history=new ArrayList<>();

    public Application(int id, int programId, int candidateId, List<ApplicationStatus> history) {
        this.id = id;
        this.programId = programId;
        this.candidateId = candidateId;
        this.history = history;
    }

    public Application(int programId, int candidateId) {
        this.programId = programId;
        this.candidateId = candidateId;
        this.id = -1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public void setHistory(List<ApplicationStatus> history) {
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public int getProgramId() {
        return programId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public List<ApplicationStatus> getHistory() {
        return history;
    }

    public void updateStatus(ApplicationStatus newStatus) {
        history.add(newStatus);
    }

    public ApplicationStatus getStatus() {
        return history.get(history.size() - 1);
    }
}
