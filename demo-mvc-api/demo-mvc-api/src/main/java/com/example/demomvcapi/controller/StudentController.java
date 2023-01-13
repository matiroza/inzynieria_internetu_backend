package com.example.demomvcapi.controller;

import com.example.demomvcapi.entity.Student;
import com.example.demomvcapi.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {
    public StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(
            @PathVariable(name = "id") Long id,
            @ModelAttribute("student") Student student,
            Model model) {
        Student student1 = studentService.getStudentById(id);

        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());

        studentService.updateStudent(student1);
        return "redirect:/students";
    }

    @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


}
