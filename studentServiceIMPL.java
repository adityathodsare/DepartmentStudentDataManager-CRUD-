package net.DBMSprojectAny.backendForProject.service.serviceIMPL;

import lombok.AllArgsConstructor;
import net.DBMSprojectAny.backendForProject.dto.studentDto;
import net.DBMSprojectAny.backendForProject.entity.student;
import net.DBMSprojectAny.backendForProject.exception.ResourceNotFoundException;
import net.DBMSprojectAny.backendForProject.mapper.studentMapper;
import net.DBMSprojectAny.backendForProject.repository.studentRepository;
import net.DBMSprojectAny.backendForProject.service.studentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class studentServiceIMPL implements studentService {

    private studentRepository StudentRepository;

    @Override
    public studentDto addStudent(studentDto StudentDto) {
        student student = studentMapper.mapToStudent(StudentDto);// converting DTO to JPA entity
        student savedStudent = StudentRepository.save(student); //save jpa to repository
        return studentMapper.mapToStudentDto(savedStudent); //as method return dto so again convert jpa to dto by mapper
    }

    @Override
    public studentDto getStudentById(Long id) {
    student student= StudentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("student not exists with a given id :"+ id));


       return studentMapper.mapToStudentDto(student);
    }

    @Override
    public List<studentDto> getAllStudents() {
        List<student> student =StudentRepository.findAll();
        return student.stream().map(student1 -> studentMapper.mapToStudentDto(student1))
                .collect(Collectors.toList());
    }

    @Override
    public studentDto updateStudentInformation(Long id, studentDto updatedStudentINFO) {

        student student= StudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student not exists with a given id :"+ id));

        student.setFirstName(updatedStudentINFO.getFirstName());
        student.setLastName(updatedStudentINFO.getLastName());
        student.setYearOfStudy(updatedStudentINFO.getYearOfStudy());
        student.setPhoneNo(updatedStudentINFO.getPhoneNo());
        student.setEmail(updatedStudentINFO.getEmail());
        student.setAddress(updatedStudentINFO.getAddress());
        student.setElectiveSub1(updatedStudentINFO.getElectiveSub1());
        student.setElectiveSub2(updatedStudentINFO.getElectiveSub2());
        student.setCgpa1(updatedStudentINFO.getCgpa1());
        student.setCgpa2(updatedStudentINFO.getCgpa2());
        student.setCgpa3(updatedStudentINFO.getCgpa3());
        student.setCgpa4(updatedStudentINFO.getCgpa4());

        student updatedStudentObj = StudentRepository.save(student);

        return studentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long id) {
        student student= StudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student not exists with a given id :"+ id));

        StudentRepository.deleteById(id);

    }

    @Override
    public List<student> fetchingByYearFE() {
        return StudentRepository.fetchUsingCurrentYear("FE");
    }

    @Override
    public List<student> fetchingByYearSE() {
        return StudentRepository.fetchUsingCurrentYear("SE");
    }

    @Override
    public List<student> fetchingByYearTE() {
        return StudentRepository.fetchUsingCurrentYear("TE");
    }

    @Override
    public List<student> fetchingByYearBE() {
        return StudentRepository.fetchUsingCurrentYear("BE");
    }

}
