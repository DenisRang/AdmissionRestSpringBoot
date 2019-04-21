package ru.myuniversity.admissionrest.dao;

import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.List;

public interface TestDao {
    //Tests composition
    int createTest(Test test);

    List<Test> getTests();

    Double getTestGrade(int testId);

    void updateTest(Test test);

    void deleteTest(int testId);

    void createQuestion(int testId, Question question);

    List<Question> getQuestions(int testId);

    void updateQuestion(int testId, Question question);

    void deleteQuestion(int testId, int questionId);

    //Tests passing
    void submitTextAnswer(int testId, int questionId, String answer);

    void submitVariantsListAnswer(int testId, int questionId, List<Integer> chosenVariants);

    double finishTest(int testId);
}
