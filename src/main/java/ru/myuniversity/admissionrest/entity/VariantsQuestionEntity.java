package ru.myuniversity.admissionrest.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class VariantsQuestionEntity extends QuestionEntity {

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "question_id")
    private Set<AnswerVariantEntity> answerVariants = new HashSet<>();

    public VariantsQuestionEntity() {
    }

    public VariantsQuestionEntity(String description, double weight) {
        super(description, weight);
    }

    public Set<AnswerVariantEntity> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(Set<AnswerVariantEntity> answerVariants) {
        this.answerVariants = answerVariants;
    }

    @Override
    public String toString() {
        return "VariantsQuestionEntity{" +
                "answerVariants=" + answerVariants +
                '}';
    }
}
