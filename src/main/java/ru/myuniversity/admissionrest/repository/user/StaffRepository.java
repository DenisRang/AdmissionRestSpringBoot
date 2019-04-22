package ru.myuniversity.admissionrest.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;
import ru.myuniversity.admissionrest.entity.user.StaffEntity;

import java.util.List;

public interface StaffRepository extends CrudRepository<StaffEntity,Integer> {

    @Query("SELECT user FROM StaffEntity user WHERE user.name LIKE CONCAT('%',:name,'%')")
    List<StaffEntity> findUsersWithName(@Param("name") String name);

}
