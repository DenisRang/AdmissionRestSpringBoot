package ru.myuniversity.admissionrest.entity.question;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "radio_question")
public class RadioQuestionEntity extends VariantsQuestionEntity{

    public RadioQuestionEntity() {
    }

    public RadioQuestionEntity(String description, double weight) {
        super(description, weight);
    }

    @Override
    public void accept(QuestionEntityVisitor visitor) {
        visitor.visit(this);
    }
}
