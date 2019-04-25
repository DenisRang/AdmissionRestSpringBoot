package ru.myuniversity.admissionrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.myuniversity.admissionrest.entity.application.ApplicationEntity;
import ru.myuniversity.admissionrest.entity.application.ApplicationStatusEntity;
import ru.myuniversity.admissionrest.entity.attempt.QuestionAttemptEntity;

import java.util.List;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatusEntity, Integer> {

    @Query("SELECT applicationStatus FROM ApplicationStatusEntity applicationStatus WHERE applicationStatus.application=:applicationEntity")
    List<ApplicationStatusEntity> findAllByApplication(@Param("applicationEntity") ApplicationEntity applicationEntity);
}
