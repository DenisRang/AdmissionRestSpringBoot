package ru.myuniversity.admissionrest.model.test;

import java.util.List;

/**
 * This specification of a question attempt contains information about an attempt to solve a
 * {@link ru.myuniversity.admissionrest.model.question.VariantsQuestion}.
 */
public class VariantsQuestionAttempt extends QuestionAttempt {
    private List<Integer> chosenVariants;

    public VariantsQuestionAttempt(int questionId, List<Integer> chosenVariants) {
        super(questionId);
        this.chosenVariants = chosenVariants;
    }

    public List<Integer> getChosenVariants() {
        return chosenVariants;
    }

    @Override
    public void accept(QuestionAttemptVisitor visitor) {
        visitor.visit(this);
    }
}
