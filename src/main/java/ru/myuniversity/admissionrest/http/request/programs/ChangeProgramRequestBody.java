package ru.myuniversity.admissionrest.http.request.programs;

import org.springframework.lang.Nullable;

import java.util.List;

public class ChangeProgramRequestBody {
    @Nullable
    private List<Integer> tests;

    @Nullable
    private String title;

    @Nullable
    public List<Integer> getTests() {
        return tests;
    }

    @Nullable
    public String getTitle() {
        return title;
    }
}
