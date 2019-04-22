package ru.myuniversity.admissionrest.entity.question;

public interface QuestionEntityVisitor {
    void visit(TextQuestionEntity textQuestionEntity);

    void visit(RadioQuestionEntity radioQuestionEntity);

    void visit(ChecklistQuestionEntity checklistQuestionEntity);
}
