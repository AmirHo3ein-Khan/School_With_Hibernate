package ir.school.model;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Teacher extends Users {
    @OneToOne
    private Course course;
}
