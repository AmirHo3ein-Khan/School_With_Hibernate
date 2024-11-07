package ir.school.repository.impl;

import ir.school.model.Teacher;
import ir.school.repository.StudentRepository;
import ir.school.repository.base.BaseRepositoryImpl;
import ir.school.util.EntityManagerSingleton;
import ir.school.model.Student;

import javax.persistence.EntityManager;
import java.util.Optional;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {
    public StudentRepositoryImpl(Class<Student> entityType) {
        super(entityType);
    }
    @Override
    protected String getTableName() {
        return "Student";
    }

    @Override
    protected void updateEntity(Student entity) {
        Optional<Student> optional = find(entity.getId());
        optional.get().setFirstName(entity.getFirstName());
        optional.get().setLastName(entity.getLastName());
        optional.get().setNationalCode(entity.getNationalCode());
        optional.get().setDob(entity.getDob());
        optional.get().setUsername(entity.getUsername());
        optional.get().setPassword(entity.getPassword());
    }

}
