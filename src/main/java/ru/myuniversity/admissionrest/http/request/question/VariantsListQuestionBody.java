package ru.myuniversity.admissionrest.http.request.question;

import ru.myuniversity.admissionrest.model.answer.AllAnswerVariants;

public abstract class VariantsListQuestionBody extends QuestionRequestBody {
    private AllAnswerVariants variants;

    public AllAnswerVariants getVariants() {
        return variants;
    }
}
