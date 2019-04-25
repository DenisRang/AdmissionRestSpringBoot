package ru.myuniversity.admissionrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myuniversity.admissionrest.entity.ProgramEntity;
import ru.myuniversity.admissionrest.entity.application.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {
}
