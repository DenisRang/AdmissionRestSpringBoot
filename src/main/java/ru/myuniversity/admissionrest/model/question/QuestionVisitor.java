package ru.myuniversity.admissionrest.model.question;

/**
 * An interface for visiting descendants of {@link Question} POJO model.
 * Can be used for mapping it into other types.
 */
public interface QuestionVisitor {
    void visit(TextQuestion textQuestion);
    void visit(ChecklistQuestion checklistQuestion);
    void visit(RadioQuestion radioQuestion);
}
