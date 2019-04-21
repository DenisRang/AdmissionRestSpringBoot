package ru.myuniversity.admissionrest.http.response.applications;

import ru.myuniversity.admissionrest.http.response.programs.ProgramResponse;
import ru.myuniversity.admissionrest.http.response.users.UserResponse;

/**
 * A single item in a list of applications, that is returned in an applications retrieval request.
 */
public class ApplicationListResponseItem {
    private int id;
    private ProgramResponse program;
    private UserResponse candidate;
    private ApplicationStatusResponse status;

    public ApplicationListResponseItem(int id, ProgramResponse program, UserResponse candidate, ApplicationStatusResponse status) {
        this.id = id;
        this.program = program;
        this.candidate = candidate;
        this.status = status;
    }
}
