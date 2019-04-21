package ru.myuniversity.admissionrest.model.question;

public class TextQuestion extends Question {
    private String answer;

    public TextQuestion(int id, String description, double weight, String answer) {
        super(id, description, weight);
        this.answer = answer;
    }

    public TextQuestion(String description, double weight, String answer) {
        super(description, weight);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public void accept(QuestionVisitor visitor) {
        visitor.visit(this);
    }
}
