package ru.myuniversity.admissionrest.http.response.tests;

import ru.myuniversity.admissionrest.model.test.VariantsQuestionAttempt;

import java.util.List;

public class VariantsQuestionAttemptResponse extends QuestionAttemptResponse {
    private List<Integer> chosenVariants;

    public VariantsQuestionAttemptResponse(VariantsQuestionAttempt pojoAttempt) {
        super(pojoAttempt);
        chosenVariants = pojoAttempt.getChosenVariants();
    }
}
