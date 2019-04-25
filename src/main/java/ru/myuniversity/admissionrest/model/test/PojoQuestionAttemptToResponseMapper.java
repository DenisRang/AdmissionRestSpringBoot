package ru.myuniversity.admissionrest.model.test;

import ru.myuniversity.admissionrest.http.response.tests.QuestionAttemptResponse;
import ru.myuniversity.admissionrest.http.response.tests.TextQuestionAttemptResponse;
import ru.myuniversity.admissionrest.http.response.tests.VariantsQuestionAttemptResponse;

public class PojoQuestionAttemptToResponseMapper implements QuestionAttemptVisitor {
    private QuestionAttemptResponse result;

    public PojoQuestionAttemptToResponseMapper() {}

    public QuestionAttemptResponse getResult() {
        return result;
    }

    @Override
    public void visit(TextQuestionAttempt textQuestionAttempt) {
        result = new TextQuestionAttemptResponse(textQuestionAttempt);
    }

    @Override
    public void visit(VariantsQuestionAttempt variantsQuestionAttempt) {
        result = new VariantsQuestionAttemptResponse(variantsQuestionAttempt);
    }

    public static QuestionAttemptResponse map(QuestionAttempt pojoAttempt) {
        PojoQuestionAttemptToResponseMapper mapper = new PojoQuestionAttemptToResponseMapper();
        pojoAttempt.accept(mapper);

        return mapper.getResult();
    }
}
