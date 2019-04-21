package ru.myuniversity.admissionrest.model.question;


import ru.myuniversity.admissionrest.model.answer.AllAnswerVariants;

public abstract class VariantsQuestion extends Question {
    private AllAnswerVariants variants;

    public VariantsQuestion(int id, String description, double weight, AllAnswerVariants variants) {
        super(id, description, weight);
        this.variants = variants;
    }

    public VariantsQuestion(String description, double weight) {
        super(description, weight);
    }

    public VariantsQuestion(int id, String description, double weight) {
        super(id, description, weight);
    }

    public VariantsQuestion(String description, double weight, AllAnswerVariants variants) {
        super(description, weight);
        this.variants = variants;
    }

    public AllAnswerVariants getVariants() {
        return variants;
    }

    public void setVariants(AllAnswerVariants variants) {
        this.variants = variants;
    }

}
