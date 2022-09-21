package com.pedroreiscoder.student.services;

import com.pedroreiscoder.student.models.Student;
import com.pedroreiscoder.student.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public boolean studentExists(Long id){
        return studentRepository.existsById(id);
    }

    @Override
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
