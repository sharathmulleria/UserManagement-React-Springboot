package com.ems.service;
import com.ems.dto.EmployeeDto;
import com.ems.model.Employees;
import java.util.List;

public interface EmployeeService {

    public List<Employees> listEmployee();

    public EmployeeDto addEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(Long employeeId);

    public List<EmployeeDto> getAllEmployee();

    public EmployeeDto updateEmployee(EmployeeDto employeeDto);

    public Employees findEmployeeName(String firstName);

    public void deleteEmployee(Long id);
}
