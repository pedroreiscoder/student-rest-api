package com.pedroreiscoder.student.services;

import com.pedroreiscoder.student.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getStudents();
    Optional<Student> getStudent(Long id);
    Student saveStudent(Student student);
    boolean studentExists(Long id);
    void deleteStudent(Long id);
}
