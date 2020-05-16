package ru.geekbrains.DAO;

import ru.geekbrains.models.Student;

import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 15.05.2020
 */
public interface StudentDAO {

    public void save(Student student);

    public boolean remove(Student student);

    public boolean removeById(Long id);

    public Student findById(Long id);

    public List<Student> findAll();

    public void update(Student student);

}
