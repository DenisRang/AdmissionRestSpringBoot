package ru.myuniversity.admissionrest.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class ManagerEntity extends UserEntity {
    public ManagerEntity() {
    }

    public ManagerEntity(String name, String email) {
        super(name, email);
    }
}
