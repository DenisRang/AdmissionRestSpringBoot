package ru.myuniversity.admissionrest.entity.question;

import ru.myuniversity.admissionrest.entity.AnswerVariantEntity;
import ru.myuniversity.admissionrest.model.answer.AllAnswerVariants;
import ru.myuniversity.admissionrest.model.answer.AnswerVariant;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.question.RadioQuestion;
import ru.myuniversity.admissionrest.model.question.TextQuestion;
import ru.myuniversity.admissionrest.model.question.VariantsQuestion;

import java.util.ArrayList;
import java.util.List;

public class QuestionEntityToPojoMapper implements QuestionEntityVisitor {
    private Question result;

    public Question getResult() {
        return result;
    }

    @Override
    public void visit(TextQuestionEntity textQuestionEntity) {
        result = new TextQuestion(textQuestionEntity.getId(),
                textQuestionEntity.getDescription(),
                textQuestionEntity.getWeight(),
                textQuestionEntity.getAnswer());
    }

    @Override
    public void visit(RadioQuestionEntity radioQuestionEntity) {
        result = new RadioQuestion(radioQuestionEntity.getId(),
                radioQuestionEntity.getDescription(),
                radioQuestionEntity.getWeight());
        ((VariantsQuestion) result).setVariants(getAnswerVariants(radioQuestionEntity));
    }

    @Override
    public void visit(ChecklistQuestionEntity checklistQuestionEntity) {
        result = new RadioQuestion(checklistQuestionEntity.getId(),
                checklistQuestionEntity.getDescription(),
                checklistQuestionEntity.getWeight());
        ((VariantsQuestion) result).setVariants(getAnswerVariants(checklistQuestionEntity));
    }

    private AllAnswerVariants getAnswerVariants(VariantsQuestionEntity questionEntity) {
        List<AnswerVariant> correct = new ArrayList<>();
        List<AnswerVariant> other = new ArrayList<>();
        for (AnswerVariantEntity entity : questionEntity.getAnswerVariants()) {
            if (entity.isCorrect()) {
                correct.add(new AnswerVariant(entity.getId(), entity.getText()));
            } else {
                other.add(new AnswerVariant(entity.getId(), entity.getText()));
            }
        }
        return new AllAnswerVariants(correct, other);
    }

    public static Question map(QuestionEntity questionEntity) {
        QuestionEntityToPojoMapper mapper = new QuestionEntityToPojoMapper();
        questionEntity.accept(mapper);
        return mapper.getResult();
    }
}
