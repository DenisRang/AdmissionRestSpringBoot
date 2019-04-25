package ru.myuniversity.admissionrest.model.question;

import ru.myuniversity.admissionrest.entity.*;
import ru.myuniversity.admissionrest.entity.question.*;
import ru.myuniversity.admissionrest.model.answer.AnswerVariant;

import java.util.*;

public class QuestionPOJOToEntityMapper implements QuestionVisitor {
    private QuestionEntity result;

    public QuestionEntity getResult() {
        return result;
    }

    @Override
    public void visit(TextQuestion textQuestion) {
        result = new TextQuestionEntity(textQuestion.getDescription(),
                textQuestion.getWeight(),
                textQuestion.getAnswer());
    }

    @Override
    public void visit(ChecklistQuestion checklistQuestion) {
        result = new ChecklistQuestionEntity(checklistQuestion.getDescription(),
                checklistQuestion.getWeight());
        ((VariantsQuestionEntity) result).setAnswerVariants(getAnswerVariants(checklistQuestion));
    }

    @Override
    public void visit(RadioQuestion radioQuestion) {
        result = new RadioQuestionEntity(radioQuestion.getDescription(),
                radioQuestion.getWeight());
        ((VariantsQuestionEntity) result).setAnswerVariants(getAnswerVariants(radioQuestion));
    }

    private List<AnswerVariantEntity> getAnswerVariants(VariantsQuestion question) {
        List<AnswerVariantEntity> variants = getPartVariants(question.getVariants().getCorrect(), true);
        variants.addAll(getPartVariants(question.getVariants().getOther(), false));
        return variants;
    }

    private List<AnswerVariantEntity> getPartVariants(List<AnswerVariant> variants, boolean isCorrect) {
        return variants.stream()
                .collect(ArrayList::new,
                        (set, item) -> {
                            AnswerVariantEntity answerVariantEntity = new AnswerVariantEntity(null,item.getText(), isCorrect);
                            set.add(answerVariantEntity);
                        },
                        AbstractCollection::addAll
                );
    }

    public static QuestionEntity map(Question question) {
        QuestionPOJOToEntityMapper mapper = new QuestionPOJOToEntityMapper();
        question.accept(mapper);
        return mapper.getResult();
    }
}
