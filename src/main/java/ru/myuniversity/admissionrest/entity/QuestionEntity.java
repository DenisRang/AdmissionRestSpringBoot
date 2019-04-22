package ru.myuniversity.admissionrest.entity;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "question")
public abstract class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "test_id")
    private TestEntity test;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private double weight;

    public QuestionEntity() {

    }

    public QuestionEntity(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    public abstract void accept(QuestionEntityVisitor visitor);

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

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}
