package ir.school.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Student extends Users {
    @ManyToMany
    private List<Course> courses = new ArrayList<>();
    @ManyToMany(mappedBy = "students")
    private List<Exam> exams = new ArrayList<>();
}
