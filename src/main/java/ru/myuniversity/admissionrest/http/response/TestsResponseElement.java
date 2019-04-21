package ru.myuniversity.admissionrest.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import ru.myuniversity.admissionrest.model.test.Test;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestsResponseElement {
    @JsonUnwrapped @NonNull
    private Test test;

    @Nullable
    private Double grade;

    public TestsResponseElement(Test test, @Nullable Double grade) {
        this.test = test;
        this.grade = grade;
    }

    public Test getTest() {
        return test;
    }
}
