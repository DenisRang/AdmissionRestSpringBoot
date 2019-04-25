package ru.myuniversity.admissionrest.repository.attempt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.myuniversity.admissionrest.entity.attempt.QuestionAttemptEntity;
import ru.myuniversity.admissionrest.entity.attempt.TestAttemptEntity;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;

import java.util.List;

public interface TestAttemptRepository extends JpaRepository<TestAttemptEntity, Integer> {

    @Query("SELECT testAttempt FROM TestAttemptEntity testAttempt WHERE testAttempt.candidate=:userId and testAttempt.test=:testId ")
    List<TestAttemptEntity> findByUserAndTestId(@Param("userId") Integer userId, @Param("testId") Integer testId);
}
