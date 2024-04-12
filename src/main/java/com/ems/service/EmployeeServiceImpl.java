package com.ems.service;
import com.ems.dto.EmployeeDto;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.model.Employees;
import com.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employees> listEmployee() {
        return employeeRepository.findAll();
    }


    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employees emp = EmployeeMapper.mapToEmployee(employeeDto);
        Employees savedEmployee = employeeRepository.save(emp);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employees employees =  employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceAccessException("Employee is not exist in given Id "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employees);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employees> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employees employees = findEmployeeName(employeeDto.getFirstName());
        employees.setFirstName(employeeDto.getFirstName());
        employees.setLastName(employeeDto.getLastName());
        employees.setEmail(employeeDto.getEmail());
        Employees updatedEmployee = employeeRepository.save(employees);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public Employees findEmployeeName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }


    public void deleteEmployee(Long id){
        Employees employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
        employeeRepository.deleteById(id);
    }


}
