package ru.myuniversity.admissionrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "text_question")
public class TextQuestionEntity extends QuestionEntity {
    @Column(name = "answer")
    private String answer;

    public TextQuestionEntity() {
    }

    public TextQuestionEntity(String description, double weight, String answer) {
        super(description, weight);
        this.answer = answer;
    }

    @Override
    public void accept(QuestionEntityVisitor visitor) {
        visitor.visit(this);
    }

    public TextQuestionEntity(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "TextQuestionEntity{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
