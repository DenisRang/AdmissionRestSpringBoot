package ru.myuniversity.admissionrest.model.answer;

public class AnswerVariant {
    int id;
    String text;

    public AnswerVariant(){
    }

    public AnswerVariant(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
