package ru.myuniversity.admissionrest.http.response.tests;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.myuniversity.admissionrest.model.test.QuestionAttempt;
import ru.myuniversity.admissionrest.model.test.TextQuestionAttempt;
import ru.myuniversity.admissionrest.model.test.VariantsQuestionAttempt;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = VariantsQuestionAttempt.class, name = "variants"),
        @JsonSubTypes.Type(value = TextQuestionAttempt.class, name = "text"),
})
public abstract class QuestionAttemptResponse {
    private int questionId;

    public QuestionAttemptResponse(QuestionAttempt pojoAttempt) {
        questionId = pojoAttempt.getQuestionId();
    }
}
