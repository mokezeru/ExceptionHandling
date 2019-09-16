package com.charter.exceptionHandling.service.impl;

import com.charter.exceptionHandling.service.StudentService;
import com.charter.exceptionHandling.model.Student;
import com.charter.exceptionHandling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student findStudent(long id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }
}
