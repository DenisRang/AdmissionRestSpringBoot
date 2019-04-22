package ru.myuniversity.admissionrest.repository.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.myuniversity.admissionrest.entity.question.QuestionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    private EntityManager entityManager;

    @Autowired
    public QuestionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<QuestionEntity> findQuestionsOfTest(int testId) {
        List<QuestionEntity> questions = entityManager.createQuery(
                "from QuestionEntity where test_id=:testId", QuestionEntity.class)
                .setParameter("testId", testId)
                .getResultList();
        return questions;
    }

    @Override
    public QuestionEntity save(QuestionEntity questionEntity) {
        return entityManager.merge(questionEntity);
    }

    @Override
    public void deleteQuestionOfTestById(int testId, int questionId) {
        Query query = entityManager.createQuery("delete from QuestionEntity where test_id=:testId and id=:questionId");
        query.setParameter("testId", testId);
        query.setParameter("questionId", questionId);
        query.executeUpdate();
    }
}
