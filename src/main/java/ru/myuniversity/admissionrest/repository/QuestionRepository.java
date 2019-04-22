package ru.myuniversity.admissionrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myuniversity.admissionrest.entity.QuestionEntity;
import ru.myuniversity.admissionrest.model.question.Question;

import java.util.List;

public interface QuestionRepository {
    List<QuestionEntity> findQuestionsOfTest(int testId);

    QuestionEntity save(QuestionEntity questionEntity);

    void deleteQuestionOfTestById(int testId, int questionId);
}
