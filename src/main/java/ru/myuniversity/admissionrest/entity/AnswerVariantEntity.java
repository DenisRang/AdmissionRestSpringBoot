package ru.myuniversity.admissionrest.entity;

import ru.myuniversity.admissionrest.entity.attempt.QuestionAttemptEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answer_variant")
public class AnswerVariantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(mappedBy = "answerVariants")
    private List<QuestionAttemptEntity> questionAttempts = new ArrayList<>();

    @Column(name = "text")
    private String text;

    @Column(name = "is_correct")
    private boolean isCorrect;

    public AnswerVariantEntity() {
    }

    public AnswerVariantEntity(List<QuestionAttemptEntity> questionAttempts, String text, boolean isCorrect) {
        this.questionAttempts = questionAttempts;
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

    public List<QuestionAttemptEntity> getQuestionAttempts() {
        return questionAttempts;
    }

    public void setQuestionAttempts(List<QuestionAttemptEntity> questionAttempts) {
        this.questionAttempts = questionAttempts;
    }

    @Override
    public String toString() {
        return "AnswerVariantEntity{" +
                "id=" + id +
                ", questionAttempts=" + questionAttempts +
                ", text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
