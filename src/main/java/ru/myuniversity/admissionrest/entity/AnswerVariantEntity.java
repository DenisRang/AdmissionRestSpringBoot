package ru.myuniversity.admissionrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "answer_variant")
public class AnswerVariantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "is_correct")
    private boolean isCorrect;

    public AnswerVariantEntity() {
    }

    public AnswerVariantEntity(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "AnswerVariantEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
