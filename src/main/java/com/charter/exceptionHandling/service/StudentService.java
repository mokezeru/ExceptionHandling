package com.charter.exceptionHandling.service;

import com.charter.exceptionHandling.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAllStudents();
    public Student findStudent(long id);
    public Student saveStudent(Student student);
    public void deleteStudent(long id);
}
