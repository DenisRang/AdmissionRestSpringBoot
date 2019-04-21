package ru.myuniversity.admissionrest.model.answer;

import java.util.List;

public class AllAnswerVariants {
    private List<AnswerVariant> correct;
    private List<AnswerVariant> other;

    public AllAnswerVariants() {
    }

    public AllAnswerVariants(List<AnswerVariant> correct, List<AnswerVariant> other) {
        this.correct = correct;
        this.other = other;
    }

    public List<AnswerVariant> getCorrect() {
        return correct;
    }

    public void setCorrect(List<AnswerVariant> correct) {
        this.correct = correct;
    }

    public List<AnswerVariant> getOther() {
        return other;
    }

    public void setOther(List<AnswerVariant> other) {
        this.other = other;
    }
}
