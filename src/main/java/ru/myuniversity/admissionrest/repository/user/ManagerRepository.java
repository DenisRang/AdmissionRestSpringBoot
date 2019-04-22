package ru.myuniversity.admissionrest.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;
import ru.myuniversity.admissionrest.entity.user.ManagerEntity;

import java.util.List;

public interface ManagerRepository extends CrudRepository<ManagerEntity,Integer> {

    @Query("SELECT user FROM ManagerEntity user WHERE user.name LIKE CONCAT('%',:name,'%')")
    List<ManagerEntity> findUsersWithName(@Param("name") String name);

}
