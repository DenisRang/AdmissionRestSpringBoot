package ru.myuniversity.admissionrest.http.request.question;

/**
 * An interface for visiting either of the children of {@link QuestionRequestBody}.
 * Can be used for mapping purposes.
 */
public interface QuestionRequestBodyVisitor {
    void visit(QuestionRequestBody.TextQuestionRequestBody textQuestion);
    void visit(QuestionRequestBody.RadioQuestionRequestBody radioQuestion);
    void visit(QuestionRequestBody.ChecklistQuestionRequestBody checklistQuestion);
}
