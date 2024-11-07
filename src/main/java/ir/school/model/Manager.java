package ir.school.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NoArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Manager extends Users {
}
