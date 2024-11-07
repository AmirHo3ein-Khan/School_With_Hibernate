package ir.school.thread;

import ir.school.model.Student;
import ir.school.repository.impl.StudentRepositoryImpl;
import ir.school.util.EntityManagerSingleton;


public class StudentCounter implements Runnable {
    StudentRepositoryImpl studentRepository = new StudentRepositoryImpl(Student.class);
    @Override
    public void run() {
        try {
            while (true) {
                Long count = studentRepository.getCount();
                Thread.sleep(2000);
            System.out.println(count);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
