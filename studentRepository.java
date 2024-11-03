package net.DBMSprojectAny.backendForProject.repository;

import net.DBMSprojectAny.backendForProject.entity.student;
import net.DBMSprojectAny.backendForProject.mapper.studentMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface studentRepository extends JpaRepository<student,Long> {
    @Query(value = "SELECT s FROM student s WHERE yearOfStudy =:val")
    public List<student> fetchUsingCurrentYear(@Param("val") String yearOfStudy);


}

