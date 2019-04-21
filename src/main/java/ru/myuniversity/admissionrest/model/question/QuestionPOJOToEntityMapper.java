package ru.myuniversity.admissionrest.model.question;

import ru.myuniversity.admissionrest.entity.*;
import ru.myuniversity.admissionrest.model.answer.AnswerVariant;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Set<AnswerVariantEntity> getAnswerVariants(VariantsQuestion question) {
        Set<AnswerVariantEntity> variants = getPartVariants(question.getVariants().getCorrect(), true);
        variants.addAll(getPartVariants(question.getVariants().getOther(), false));
        return variants;
    }

    private Set<AnswerVariantEntity> getPartVariants(List<AnswerVariant> variants, boolean isCorrect) {
        return variants.stream()
                .collect(HashSet::new,
                        (set, item) -> {
                            AnswerVariantEntity answerVariantEntity = new AnswerVariantEntity(item.getText(), isCorrect);
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