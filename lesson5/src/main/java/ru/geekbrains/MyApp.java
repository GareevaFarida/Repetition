package ru.geekbrains;

import org.hibernate.Session;

import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 07.05.2020
 */
public class MyApp {
    public static void main(String[] args) {
        DAOImpl<Student, Long> dao = new DAOImpl();
        dao.openCurrentSessionWithTransaction();
        for (int i = 1; i <= 1000; i++) {
            Student student = new Student("Name_" + i, 1);
            dao.save(student);
        }
        dao.closeCurrentSessionWithTransaction();

        dao.openCurrentSessionWithTransaction();
        Student student = dao.findById(Student.class,1000L);
        System.out.println(student);
        student.setMark(3);
        System.out.println("Студенту изменили оценку.");
        dao.update(student);
        dao.closeCurrentSessionWithTransaction();

        dao.openCurrentSession();
        student = dao.findById(Student.class,1000L);
        System.out.println(student);

        List<Student> students = dao.findAll(Student.class);
        System.out.println("Всего студентов "+students.size());
        dao.closeCurrentSession();

        dao.openCurrentSessionWithTransaction();
        student = dao.findById(Student.class,1000L);
        dao.delete(student);
        dao.closeCurrentSessionWithTransaction();

        dao.openCurrentSession();
        List<Student> students1 = dao.findAll(Student.class);
        System.out.println("Количество студентов после удаления одного: " +students1.size());
        dao.closeCurrentSession();


    }
}
