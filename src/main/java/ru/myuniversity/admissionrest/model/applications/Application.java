package ru.myuniversity.admissionrest.model.applications;

import java.util.Collections;
import java.util.List;

public class Application {
    private int id;
    private int programId;
    private int candidateId;
    private List<ApplicationStatus> history;

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
        this.history = Collections.singletonList(new InitialStatus());
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
