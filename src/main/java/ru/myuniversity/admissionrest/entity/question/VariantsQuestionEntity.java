package ru.myuniversity.admissionrest.entity.question;

import ru.myuniversity.admissionrest.entity.AnswerVariantEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class VariantsQuestionEntity extends QuestionEntity {

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "question_id")
    private List<AnswerVariantEntity> answerVariants = new ArrayList<>();

    public VariantsQuestionEntity() {
    }

    public VariantsQuestionEntity(String description, double weight) {
        super(description, weight);
    }

    public List<AnswerVariantEntity> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(List<AnswerVariantEntity> answerVariants) {
        this.answerVariants = answerVariants;
    }

    @Override
    public String toString() {
        return "VariantsQuestionEntity{" +
                "answerVariants=" + answerVariants +
                '}';
    }
}
