package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.geekbrains.DAO.StudentDAO;
import ru.geekbrains.DAO.StudentDAOImpl;
import ru.geekbrains.models.Student;

/**
 * @Author Farida Gareeva
 * Created 15.05.2020
 */
public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO studentDAO = context.getBean(StudentDAOImpl.class);
        Student student = new Student("Петров", 18);
        studentDAO.save(student);

        Student student2 = new Student("Сидоров", 17);
        studentDAO.save(student2);

        student = studentDAO.findById(1L);
        System.out.println("До обновления " + student.toString());
        student.setAge(99);
        studentDAO.update(student);

        student = studentDAO.findById(1L);
        System.out.println("После обновления " + student.toString());
        studentDAO.removeById(2L);

        System.out.println("Total count of students is " + studentDAO.findAll().size());

    }
}
