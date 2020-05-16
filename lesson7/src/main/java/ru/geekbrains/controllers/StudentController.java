package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.DAO.StudentDAO;
import ru.geekbrains.models.Student;

import javax.jws.WebParam;

/**
 * @Author Farida Gareeva
 * Created 16.05.2020
 */
@Controller
@RequestMapping("students")
public class StudentController {

    private StudentDAO repository;

    @Autowired
    public StudentController(StudentDAO repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showAllStudents(Model model){
        model.addAttribute("students",repository.findAll());
        return "students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(Model model, @PathVariable("id") Long id){
        model.addAttribute("student",repository.findById(id));
        return "student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable("id") Long id) {
        repository.removeById(id);
        return "redirect:/students";
    }

    @GetMapping("/save")
    public String createStudent(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/student")
    public String saveStudent(Student student){
        repository.save(student);
        return "redirect:/students";
    }


}
