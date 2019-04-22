package ru.myuniversity.admissionrest.repository.question;

import ru.myuniversity.admissionrest.entity.question.QuestionEntity;

import java.util.List;

public interface QuestionRepository {
    List<QuestionEntity> findQuestionsOfTest(int testId);

    QuestionEntity save(QuestionEntity questionEntity);

    void deleteQuestionOfTestById(int testId, int questionId);
}
