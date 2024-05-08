package com.ems.dto;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String profilePic;
}
