package ru.myuniversity.admissionrest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.myuniversity.admissionrest.entity.QuestionEntity;
import ru.myuniversity.admissionrest.entity.QuestionEntityToPojoMapper;
import ru.myuniversity.admissionrest.entity.TestEntity;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.question.QuestionPOJOToEntityMapper;
import ru.myuniversity.admissionrest.model.test.Test;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TestDaoImpl implements TestDao {

    private final EntityManager entityManager;

    @Autowired
    public TestDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public int createTest(Test test) {
        Session session = entityManager.unwrap(Session.class);
        TestEntity testEntity = new TestEntity(test.getTitle());
        return (Integer) session.save(testEntity);
    }

    @Override
    @Transactional
    public List<Test> getTests() {
        Session session = entityManager.unwrap(Session.class);
        Query<TestEntity> theQuery = session.createQuery("from TestEntity", TestEntity.class);
        List<Test> tests = theQuery.getResultList()
                .stream()
                .map((testEntity) -> new Test(testEntity.getId(), testEntity.getTitle()))
                .collect(Collectors.toList());
        return tests;
    }

    @Override
    public Double getTestGrade(int testId) {
        return null;
    }

    @Override
    @Transactional
    public void updateTest(Test test) {
        TestEntity testEntity = new TestEntity(test.getId(), test.getTitle());
        Session session = entityManager.unwrap(Session.class);
        session.update(testEntity);
    }

    @Override
    @Transactional
    public void deleteTest(int testId) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("delete from TestEntity where id=:testId");
        theQuery.setParameter("testId", testId);
        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void createQuestion(int testId, Question question) {
        Session session = entityManager.unwrap(Session.class);
        TestEntity testEntity = session.get(TestEntity.class, testId);

        QuestionEntity questionEntity = QuestionPOJOToEntityMapper.map(question);

        testEntity.addQuestion(questionEntity);
        session.save(questionEntity);
    }

    @Override
    @Transactional
    public List<Question> getQuestions(int testId) {
        Session session = entityManager.unwrap(Session.class);
        TestEntity testEntity = session.get(TestEntity.class, testId);
        List<Question> questions = testEntity.getQuestions()
                .stream()
                .map(QuestionEntityToPojoMapper::map)
                .collect(Collectors.toList());
        return questions;
    }

    @Override
    @Transactional
    public void updateQuestion(int testId, Question question) {
        Session session = entityManager.unwrap(Session.class);
        TestEntity testEntity = session.get(TestEntity.class, testId);
//        QuestionEntity questionEntity = constructNewQuestion(testId, question);
//        questionEntity.setTest(testEntity);
//        questionEntity.setId(question.getId());
//        session.update(questionEntity);
    }

    @Override
    @Transactional
    public void deleteQuestion(int testId, int questionId) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("delete from QuestionEntity where test_id=:testId and id=:questionId");
        theQuery.setParameter("testId", testId);
        theQuery.setParameter("questionId", questionId);
        theQuery.executeUpdate();
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
