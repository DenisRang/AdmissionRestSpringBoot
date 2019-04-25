package ru.myuniversity.admissionrest.entity.application;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "initial_status")
public class InitialStatusEntity extends ApplicationStatusEntity {
    public InitialStatusEntity(ApplicationEntity application, Date createDateTime) {
        super(application, createDateTime);
    }

    @Override
    public void accept(ApplicationStatusEntityVisitor visitor) {
        visitor.visit(this);
    }
}
