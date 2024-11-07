package ir.school.repository.impl;

import ir.school.repository.ExamRepository;
import ir.school.repository.base.BaseRepositoryImpl;
import ir.school.util.EntityManagerSingleton;
import ir.school.model.Exam;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ExamRepositoryImpl extends BaseRepositoryImpl<Exam> implements ExamRepository {
    public ExamRepositoryImpl(Class<Exam> entityType) {
        super(entityType);
    }
    @Override
    protected String getTableName() {
        return "Exam";
    }

    @Override
    protected void updateEntity(Exam entity) {
        Optional<Exam> exam = find(entity.getId());
        exam.get().setExamDate(entity.getExamDate());
        exam.get().setGrade(entity.getGrade());
        exam.get().setCourse(entity.getCourse());
    }


}
