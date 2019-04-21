package ru.myuniversity.admissionrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myuniversity.admissionrest.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
