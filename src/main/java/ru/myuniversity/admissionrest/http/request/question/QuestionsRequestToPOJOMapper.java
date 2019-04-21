package ru.myuniversity.admissionrest.http.request.question;

import ru.myuniversity.admissionrest.model.question.ChecklistQuestion;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.question.RadioQuestion;
import ru.myuniversity.admissionrest.model.question.TextQuestion;

/**
 * A service entity that maps the children of {@link QuestionRequestBody} to
 * their POJO counterparts.
 */
public class QuestionsRequestToPOJOMapper implements QuestionRequestBodyVisitor {
    /**
     * Result of a visit.
     * Becomes non-null after a visit.
     */
    private Question result;

    public Question getResult() {
        return result;
    }

    @Override
    public void visit(QuestionRequestBody.TextQuestionRequestBody textQuestion) {
        result = new TextQuestion(textQuestion.getDescription(), textQuestion.getWeight(), textQuestion.getAnswer());
    }

    @Override
    public void visit(QuestionRequestBody.RadioQuestionRequestBody radioQuestion) {
        result = new RadioQuestion(radioQuestion.getDescription(), radioQuestion.getWeight(), radioQuestion.getVariants());
    }

    @Override
    public void visit(QuestionRequestBody.ChecklistQuestionRequestBody checklistQuestion) {
        result = new ChecklistQuestion(checklistQuestion.getDescription(), checklistQuestion.getWeight(), checklistQuestion.getVariants());
    }

    public static Question map(QuestionRequestBody requestBody) {
        QuestionsRequestToPOJOMapper mapper = new QuestionsRequestToPOJOMapper();
        requestBody.accept(mapper);
        return mapper.getResult();
    }
}
