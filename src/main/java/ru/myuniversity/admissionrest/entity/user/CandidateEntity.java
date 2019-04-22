package ru.myuniversity.admissionrest.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class CandidateEntity extends UserEntity {
    public CandidateEntity() {
    }

    public CandidateEntity(String name, String email) {
        super(name, email);
    }
}
