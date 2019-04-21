package ru.myuniversity.admissionrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myuniversity.admissionrest.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
}
