package net.DBMSprojectAny.backendForProject.controller;


import lombok.AllArgsConstructor;
import net.DBMSprojectAny.backendForProject.dto.studentDto;
import net.DBMSprojectAny.backendForProject.entity.student;
import net.DBMSprojectAny.backendForProject.service.studentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class studentController {

    private studentService studentService;

    // to add the student in the database
    @PostMapping
    public ResponseEntity<studentDto> createStudent(@RequestBody studentDto studentDto){
        studentDto savedStudent = studentService.addStudent(studentDto);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<studentDto> getStudentById(@PathVariable("id") Long id){
        studentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<studentDto>> getAllStudents(){
        List<studentDto> students= studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("{id}")
    public ResponseEntity<studentDto> updateStudentInformation(@PathVariable("id") Long id,
                                                               @RequestBody studentDto updatedStudent){
       studentDto studentDto=  studentService.updateStudentInformation(id,updatedStudent);
       return ResponseEntity.ok(studentDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("student information deleted successfully");
    }

    @GetMapping("/yearOfStudyFE")
    public List<student> fatchinfoFE(){
        return studentService.fetchingByYearFE();
    }

    @GetMapping("/yearOfStudySE")
    public List<student> fatchinfoSE(){
        return studentService.fetchingByYearSE();
    }

    @GetMapping("/yearOfStudyTE")
    public List<student> fatchinfoTE(){
        return studentService.fetchingByYearTE();
    }

    @GetMapping("/yearOfStudyBE")
    public List<student> fatchinfoBE(){
        return studentService.fetchingByYearBE();
    }


}
