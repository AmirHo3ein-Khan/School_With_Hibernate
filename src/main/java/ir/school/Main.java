package ir.school;
import ir.school.model.*;
import ir.school.model.type.UserType;
import ir.school.repository.impl.CourseRepositoryImpl;
import ir.school.repository.impl.ExamRepositoryImpl;
import ir.school.repository.impl.StudentRepositoryImpl;
import ir.school.repository.impl.TeacherRepositoryImpl;
import ir.school.thread.StudentCounter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl(Student.class);
        TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl(Teacher.class);
        CourseRepositoryImpl courseRepository = new CourseRepositoryImpl(Course.class);
        ExamRepositoryImpl examRepository = new ExamRepositoryImpl(Exam.class);

// =====================================================================================================================
        StudentCounter studentCounter = new StudentCounter();
        Thread thread = new Thread(studentCounter);
        thread.start();
// =====================================================================================================================
        Student student = Student.builder().
                firstName("morad").
                lastName("mohseni").
                dob(new Date(2000-05-04)).
                username("morad123").
                password("6542").
                nationalCode("3219449315").
                userType(UserType.STUDENT).
                build();
        studentRepository.create(student);

        studentRepository.update(student);

        studentRepository.delete(4L);

        Optional<Student> studentOpt = studentRepository.find(1L);
        System.out.println(studentOpt.get());

        List<Student> students = studentRepository.findAll();
        for (Student st : students){
            System.out.println(st);
        }

// =====================================================================================================================
        Teacher teacher = Teacher.builder().
                id(2L).
                firstName("ali").
                lastName("najafi").
                dob(new Date(2000-05-04)).
                username("alina").
                password("6542").
                nationalCode("3216548792").
                userType(UserType.TEACHER).
                build();
        teacherRepository.create(teacher);

        teacherRepository.update(teacher);

        teacherRepository.delete(1L);

        teacherRepository.find(1L);

        List<Teacher> teachers = teacherRepository.findAll();
        for (Teacher th : teachers){
            System.out.println(th);
        }
// =====================================================================================================================
        Course course = Course.builder().
                id(9L)
                .unit(4)
                .title("History")
                .build();
        courseRepository.create(course);

        courseRepository.update(course);

        courseRepository.delete(1L);

        Optional<Course> optional = courseRepository.find(1L);
        System.out.println(optional.get());

        List<Course> courses = courseRepository.findAll();
        for (Course c : courses){
            System.out.println(c);
        }
// =====================================================================================================================
        Exam exam = Exam.builder().
                examDate(new Date(2000-05-04))
                .grade(15f)
                .build();
        examRepository.create(exam);

        examRepository.update(exam);

        examRepository.delete(1L);

        Optional<Exam> exam1 = examRepository.find(1L);
        System.out.println(exam1.get());

        List<Exam> exams = examRepository.findAll();
        for (Exam e : exams) {
            System.out.println(e);
        }

    }
}
