package ru.myuniversity.admissionrest.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;

import javax.persistence.EntityManager;
import java.util.List;

public interface CandidateRepository extends CrudRepository<CandidateEntity,Integer> {

    @Query("SELECT user FROM CandidateEntity user WHERE user.name LIKE CONCAT('%',:name,'%')")
    List<CandidateEntity> findUsersWithName(@Param("name") String name);

}
