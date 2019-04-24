package ru.myuniversity.admissionrest.http.response.programs;

import ru.myuniversity.admissionrest.http.response.tests.TestsResponseElement;
import ru.myuniversity.admissionrest.model.programs.Program;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ProgramDetailedResponse {
    private int id;
    private String title;
    List<TestsResponseElement> tests;

    public ProgramDetailedResponse(Program program, List<Test> tests) {
        this.id = program.getId();
        this.title = program.getTitle();
        this.tests = tests.stream().map(t -> new TestsResponseElement(t, null)).collect(Collectors.toList());
    }
}
