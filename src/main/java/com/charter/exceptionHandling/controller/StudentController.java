package com.charter.exceptionHandling.controller;

import com.charter.exceptionHandling.StudentService.StudentService;
import com.charter.exceptionHandling.exception.StudentNotFoundException;
import com.charter.exceptionHandling.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> retrieveAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> retrieveStudent(@PathVariable long id) {
        Student student = studentService.findStudent(id);

        if (student==null)
            throw new StudentNotFoundException("id-" + id);

       return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);

        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable long id) {

        Student studentResult = studentService.findStudent(id);

        if (studentResult == null)
            return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
        student.setId(id);
        studentService.saveStudent(student);
        return new ResponseEntity<>(studentResult, HttpStatus.OK);
    }
}
