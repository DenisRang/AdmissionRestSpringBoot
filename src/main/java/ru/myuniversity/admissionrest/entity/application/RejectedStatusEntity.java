package ru.myuniversity.admissionrest.entity.application;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "rejected_status")
public class RejectedStatusEntity {

}
