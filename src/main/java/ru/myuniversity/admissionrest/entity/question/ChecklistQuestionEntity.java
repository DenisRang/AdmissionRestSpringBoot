package ru.myuniversity.admissionrest.entity.question;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "checklist_question")
public class ChecklistQuestionEntity extends VariantsQuestionEntity{

    public ChecklistQuestionEntity() {
    }

    public ChecklistQuestionEntity(String description, double weight) {
        super(description, weight);
    }

    @Override
    public void accept(QuestionEntityVisitor visitor) {
        visitor.visit(this);
    }
}