package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.model.Employees;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employees employees){
        return  new EmployeeDto(
                employees.getEmployeeId(),
                employees.getFirstName(),
                employees.getLastName(),
                employees.getEmail(),
                employees.getProfilePic()
        );
    }

    public static Employees mapToEmployee(EmployeeDto employeeDto){
        return new Employees(
                employeeDto.getEmployeeId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getProfilePic()
        );
    }

}
