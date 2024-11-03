package net.DBMSprojectAny.backendForProject.dto;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class studentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String yearOfStudy;
    private String phoneNo;
    private String email;
    private String address;
    private String electiveSub1;
    private String electiveSub2;
    private double cgpa1;
    private double cgpa2;
    private double cgpa3;
    private double cgpa4;
}
