package ru.myuniversity.admissionrest.http.response.applications;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Date;

@JsonTypeName("initial")
public class InitialStatusResponse extends ApplicationStatusResponse {
    public InitialStatusResponse(Date changed) {
        super(changed);
    }
}
