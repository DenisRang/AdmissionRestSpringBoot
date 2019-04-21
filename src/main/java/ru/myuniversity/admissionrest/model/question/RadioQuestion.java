package ru.myuniversity.admissionrest.model.question;

import ru.myuniversity.admissionrest.model.answer.AllAnswerVariants;

public class RadioQuestion extends VariantsQuestion {
    public RadioQuestion(int id, String description, double weight, AllAnswerVariants variants) {
        super(id, description, weight, variants);
    }

    public RadioQuestion(String description, double weight, AllAnswerVariants variants) {
        super(description, weight, variants);    }

    public RadioQuestion(int id, String description, double weight) {
        super(id, description, weight);
    }

    @Override
    public void accept(QuestionVisitor visitor) {
        visitor.visit(this);
    }
}
