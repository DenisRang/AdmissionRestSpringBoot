package ru.myuniversity.admissionrest.model.test;

public interface QuestionAttemptVisitor {
    void visit(TextQuestionAttempt textQuestionAttempt);
    void visit(VariantsQuestionAttempt variantsQuestionAttempt);
}
