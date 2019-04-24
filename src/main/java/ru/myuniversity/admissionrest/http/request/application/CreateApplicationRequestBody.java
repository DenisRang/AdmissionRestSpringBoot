package ru.myuniversity.admissionrest.http.request.application;

import org.springframework.lang.NonNull;

public class CreateApplicationRequestBody {
    @NonNull
    private Integer programId;

    public Integer getProgramId() {
        return programId;
    }
}
