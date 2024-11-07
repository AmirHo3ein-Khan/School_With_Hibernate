package ir.school.model;

import ir.school.model.base.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Exam extends BaseModel<Long> {
    @Column(name = "exam_date")
    private Date examDate;
    private Float grade;
    @ManyToOne
    private Course course;
    @ManyToMany
    private List<Student> students = new ArrayList<>();
}
