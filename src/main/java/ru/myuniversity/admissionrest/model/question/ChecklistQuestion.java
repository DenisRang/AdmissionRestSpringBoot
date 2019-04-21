package ru.myuniversity.admissionrest.model.question;

import ru.myuniversity.admissionrest.model.answer.AllAnswerVariants;

public class ChecklistQuestion extends VariantsQuestion {
    public ChecklistQuestion(int id, String description, double weight, AllAnswerVariants variants) {
        super(id, description, weight, variants);
    }

    public ChecklistQuestion(String description, double weight, AllAnswerVariants variants) {
        super(description, weight, variants);
    }

    public ChecklistQuestion(String description, double weight) {
        super(description, weight);
    }

    @Override
    public void accept(QuestionVisitor visitor) {
        visitor.visit(this);
    }
}
