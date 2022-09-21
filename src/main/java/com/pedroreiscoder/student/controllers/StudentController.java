package com.pedroreiscoder.student.controllers;

import com.pedroreiscoder.student.DTOs.StudentDTO;
import com.pedroreiscoder.student.models.Student;
import com.pedroreiscoder.student.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id){
        var optionalStudent = studentService.getStudent(id);

        if(!optionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        return ResponseEntity.ok(optionalStudent.get());
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        var student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id,
                                                @RequestBody @Valid StudentDTO studentDTO){
        var optionalStudent = studentService.getStudent(id);

        if(!optionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        var student = optionalStudent.get();

        BeanUtils.copyProperties(studentDTO, student);

        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id){
        var studentExists = studentService.studentExists(id);

        if(!studentExists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}
