package net.DBMSprojectAny.backendForProject.mapper;

import net.DBMSprojectAny.backendForProject.dto.studentDto;
import net.DBMSprojectAny.backendForProject.entity.student;

public class studentMapper {



    // student madhun studentDto la
    //map jpa student entity to dto entity
    public static studentDto mapToStudentDto(student Student){
        return new studentDto(
                Student.getId(),
                Student.getFirstName(),
                Student.getLastName(),
                Student.getYearOfStudy(),
                Student.getPhoneNo(),
                Student.getEmail(),
                Student.getAddress(),
                Student.getElectiveSub1(),
                Student.getElectiveSub2(),
                Student.getCgpa1(),
                Student.getCgpa2(),
                Student.getCgpa3(),
                Student.getCgpa4()
        );
    }

    // studentDto madhun student kada
    public static student mapToStudent(studentDto StudentDto){ //convert dto to student
        return new student(
                StudentDto.getId(),
                StudentDto.getFirstName(),
                StudentDto.getLastName(),
                StudentDto.getYearOfStudy(),
                StudentDto.getPhoneNo(),
                StudentDto.getEmail(),
                StudentDto.getAddress(),
                StudentDto.getElectiveSub1(),
                StudentDto.getElectiveSub2(),
                StudentDto.getCgpa1(),
                StudentDto.getCgpa2(),
                StudentDto.getCgpa3(),
                StudentDto.getCgpa4()

        );

    }





}
