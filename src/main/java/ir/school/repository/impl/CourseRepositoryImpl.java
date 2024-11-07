package ir.school.repository.impl;

import ir.school.model.Exam;
import ir.school.repository.CourseRepository;
import ir.school.repository.base.BaseRepositoryImpl;
import ir.school.util.EntityManagerSingleton;
import ir.school.model.Course;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CourseRepositoryImpl extends BaseRepositoryImpl<Course> implements CourseRepository {
    public CourseRepositoryImpl(Class<Course> entityType) {
        super(entityType);
    }
    @Override
    protected String getTableName() {
        return "Course";
    }

    @Override
    protected void updateEntity(Course entity) {
        Optional<Course> optional = find(entity.getId());
        optional.get().setUnit(entity.getUnit());
        optional.get().setTitle(entity.getTitle());
    }

}
