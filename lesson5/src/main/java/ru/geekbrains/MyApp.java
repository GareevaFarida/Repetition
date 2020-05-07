package ru.geekbrains;

import org.hibernate.Session;

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
        
    }
}
