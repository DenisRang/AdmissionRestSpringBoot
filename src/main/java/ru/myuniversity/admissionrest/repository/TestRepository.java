package ru.myuniversity.admissionrest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.myuniversity.admissionrest.entity.TestEntity;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {
}
