package ru.myuniversity.admissionrest.model.question;

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
