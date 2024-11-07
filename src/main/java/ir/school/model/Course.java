package ir.school.model;

import ir.school.model.base.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course extends BaseModel<Long> {
    private String title;
    private Integer unit;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();
}
