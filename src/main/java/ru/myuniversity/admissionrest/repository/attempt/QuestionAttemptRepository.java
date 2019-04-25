package ru.myuniversity.admissionrest.repository.attempt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.myuniversity.admissionrest.entity.ProgramEntity;
import ru.myuniversity.admissionrest.entity.attempt.QuestionAttemptEntity;
import ru.myuniversity.admissionrest.entity.attempt.TestAttemptEntity;

import java.util.List;

public interface QuestionAttemptRepository extends JpaRepository<QuestionAttemptEntity, Integer> {

    @Query("SELECT questionAttempt FROM QuestionAttemptEntity questionAttempt WHERE questionAttempt.test_attempt_id=:testAttemptId  ")
    List<QuestionAttemptEntity> findByTestAttemptId(@Param("testAttempt") int testAttemptId);
}
