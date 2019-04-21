package ru.myuniversity.admissionrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.dao.TestDao;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private TestDao testDao;

    @Autowired
    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public int createTest(Test test) {
        return testDao.createTest(test);
    }

    @Override
    public List<Test> getTests() {
        return testDao.getTests();
    }

    @Override
    public Double getTestGrade(int testId) {
        return 0.0;
    }

    @Override
    public void updateTest(Test test) {
        testDao.updateTest(test);
    }

    @Override
    public void deleteTest(int testId) {
        testDao.deleteTest(testId);
    }

    @Override
    public void createQuestion(int testId, Question question) {
        testDao.createQuestion(testId, question);
    }

    @Override
    public List<Question> getQuestions(int testId) {
        return testDao.getQuestions(testId);
    }

    @Override
    public void updateQuestion(int testId, Question question) {
        testDao.updateQuestion(testId, question);
    }

    @Override
    public void deleteQuestion(int testId, int questionId) {
        testDao.deleteQuestion(testId, questionId);
    }

    @Override
    public void submitTextAnswer(int testId, int questionId, String answer) {

    }

    @Override
    public void submitVariantsListAnswer(int testId, int questionId, List<Integer> chosenVariants) {

    }

    @Override
    public double finishTest(int testId) {
        return 0;
    }
}
