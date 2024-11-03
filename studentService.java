package net.DBMSprojectAny.backendForProject.service;

import net.DBMSprojectAny.backendForProject.dto.studentDto;
import net.DBMSprojectAny.backendForProject.entity.student;

import java.util.List;

public interface studentService {
    // student la add karnyasathi
    studentDto addStudent(studentDto StudentDto);// add students
    // student la search karnya sathi by id
    studentDto getStudentById(Long id);
    // list of all student
    List<studentDto> getAllStudents();
    // student chi info add karnytasathi
    studentDto updateStudentInformation(Long id,studentDto updatedStudentINFO);
    // student delete
    void deleteStudent(Long id);

    
    List<student> fetchingByYearFE();

    List<student> fetchingByYearSE();

    List<student> fetchingByYearTE();

    List<student> fetchingByYearBE();

}
