package ru.myuniversity.admissionrest.entity.attempt;


import ru.myuniversity.admissionrest.entity.AnswerVariantEntity;
import ru.myuniversity.admissionrest.entity.TestEntity;
import ru.myuniversity.admissionrest.entity.question.QuestionEntity;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question_attempt")
public abstract class QuestionAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "test_attempt_id")
    private TestAttemptEntity testAttempt;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "question_attempt_answer_variant",
            joinColumns = @JoinColumn(name = "question_attempt"),
            inverseJoinColumns = @JoinColumn(name = "answer_variant")
    )
    private List<AnswerVariantEntity> answerVariants=new ArrayList<>();

    @Column(name = "grade")
    private double grade;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Column(name = "answer")
    private String answer;

    public QuestionAttemptEntity() {
    }

    public QuestionAttemptEntity(TestAttemptEntity testAttempt, QuestionEntity question, List<AnswerVariantEntity> answerVariants, double grade, QuestionType type, String answer) {
        this.testAttempt = testAttempt;
        this.question = question;
        this.answerVariants = answerVariants;
        this.grade = grade;
        this.type = type;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionAttemptEntity)) return false;
        return id != 0 && id==(((QuestionAttemptEntity) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "QuestionAttemptEntity{" +
                "id=" + id +
                ", testAttempt=" + testAttempt +
                ", question=" + question +
                ", answerVariants=" + answerVariants +
                ", grade=" + grade +
                ", type=" + type +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void addAnswerVariants(AnswerVariantEntity answerVariant) {
        answerVariants.add(answerVariant);
        answerVariant.getQuestionAttempts().add(this);
    }

    public void removeAnswerVariants(AnswerVariantEntity answerVariant) {
        answerVariants.remove(answerVariant);
        answerVariant.getQuestionAttempts().remove(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestAttemptEntity getTestAttempt() {
        return testAttempt;
    }

    public void setTestAttempt(TestAttemptEntity testAttempt) {
        this.testAttempt = testAttempt;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<AnswerVariantEntity> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(List<AnswerVariantEntity> answerVariants) {
        this.answerVariants = answerVariants;
    }
}
