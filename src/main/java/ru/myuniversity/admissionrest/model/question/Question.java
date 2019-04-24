package ru.myuniversity.admissionrest.model.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextQuestion.class, name = "text"),
        @JsonSubTypes.Type(value = ChecklistQuestion.class, name = "checklist"),
        @JsonSubTypes.Type(value = RadioQuestion.class, name = "radio"),
})
public abstract class Question {
    private int id;
    private String description;
    private double weight;

    public Question(int id, String description, double weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public Question(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void accept(QuestionVisitor visitor);
}
