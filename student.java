package net.DBMSprojectAny.backendForProject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentINFO")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOMATICALLY INCREMENT THE PRIMARY KEY
    @Column(name = "Student_id",nullable = false,unique = true)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(name = "Current_year",nullable = false)
    private String yearOfStudy;

    @Column(nullable = false)
    private String phoneNo;
    @Column(nullable = false)
    private String email;
    private String address;

    @Column(name = "Elective1")
    private String electiveSub1;
    @Column(name = "Elective2")
    private String electiveSub2;

    @Column(name = "FE_CGPA")
    private double cgpa1;
    @Column(name = "SE_CGPA")
    private double cgpa2;
    @Column(name = "TE_CGPA")
    private double cgpa3;
    @Column(name = "BE_CGPA")
    private double cgpa4;

}
