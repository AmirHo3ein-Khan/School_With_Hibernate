package ir.school.repository.impl;

import ir.school.repository.TeacherRepository;
import ir.school.repository.base.BaseRepositoryImpl;
import ir.school.util.EntityManagerSingleton;
import ir.school.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Optional;

public class TeacherRepositoryImpl extends BaseRepositoryImpl<Teacher> implements TeacherRepository {
    public TeacherRepositoryImpl(Class<Teacher> entityType) {
        super(entityType);
    }

    @Override
    protected String getTableName() {
        return "Teacher";
    }

    @Override
    protected void updateEntity(Teacher entity) {
        Optional<Teacher> optional = find(entity.getId());
        optional.get().setFirstName(entity.getFirstName());
        optional.get().setLastName(entity.getLastName());
        optional.get().setNationalCode(entity.getNationalCode());
        optional.get().setDob(entity.getDob());
        optional.get().setUsername(entity.getUsername());
        optional.get().setPassword(entity.getPassword());
        optional.get().setCourse(entity.getCourse());
    }


}
