package ru.geekbrains.DAO;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.geekbrains.models.Student;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Farida Gareeva
 * Created 15.05.2020
 */
public class StudentDAOImpl implements StudentDAO {

    private DataSource dataSource;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    public void save(Student student) {
        String query = "insert into student (name, age) values (?,?)";

        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        Object[] args = new Object[]{student.getName(), student.getAge()};

        int out = jdbcTemplate.update(query, args);

        if (out != 0) {
            System.out.println("Student saved with id=" + student.getId());
        } else System.out.println("Employee save failed with id=" + student.getId());

    }

    public boolean remove(Student student) {

        if ((student == null) ||
                (student.getId() == null))
            return false;

        String studentString = student.toString();

        String query = "delete from student where id = ?";
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        Object[] args = new Object[]{student.getId()};
        int out = jdbcTemplate.update(query, args);
        if (out != 0) {
            System.out.println("Removed " + studentString);
        }
        return out != 0;
    }

    public boolean removeById(Long id) {
        Student student = findById(id);
        return remove(student);
    }

    public Student findById(final Long id) {

        if (id == null)
            return null;

        String query = "select id, name, age from student where id = " + id;

        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        return jdbcTemplate.query(query, new ResultSetExtractor<Student>() {
            public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
                Student student = null;
                while (rs.next()) {
                    student = new Student(rs.getString("name"), rs.getInt("age"));
                    student.setId(rs.getLong("id"));
                }
                if (student == null) {
                    System.out.println("Student with id = " + id + " not found.");
                }
                return student;
            }
        });
    }

    public List<Student> findAll() {

        String query = "select id, name, age from student";
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        return jdbcTemplate.query(query, new ResultSetExtractor<List<Student>>() {
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Student> students = new ArrayList<Student>();
                while (rs.next()) {
                    Student student = new Student(rs.getString("name"), rs.getInt("age"));
                    student.setId(rs.getLong("id"));
                    students.add(student);
                }
                return students;
            }
        });
    }

    public void update(Student student) {
        String query = "update student set name='" + student.getName()
                + "', age='" + student.getAge()
                + "' where id='" + student.getId() + "' ";
        int out = getJdbcTemplate().update(query);
        if (out != 0) {
            System.out.println("Data of student id=" + student.getId() + " successfully updated!");
        }
    }
}
