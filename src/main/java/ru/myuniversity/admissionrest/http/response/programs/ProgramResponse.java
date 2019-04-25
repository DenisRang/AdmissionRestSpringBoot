package ru.myuniversity.admissionrest.http.response.programs;

import ru.myuniversity.admissionrest.model.programs.Program;

public class ProgramResponse {
    private int id;
    private String title;

    public ProgramResponse(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public ProgramResponse(Program pojoProgram) {
        this.id = pojoProgram.getId();
        this.title = pojoProgram.getTitle();
    }
}