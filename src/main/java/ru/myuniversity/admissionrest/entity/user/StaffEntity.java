package ru.myuniversity.admissionrest.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffEntity extends UserEntity {
    public StaffEntity() {
    }

    public StaffEntity(String name, String email) {
        super(name, email);
    }
}
