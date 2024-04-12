package com.ems.controller;
import com.ems.dto.EmployeeDto;
import com.ems.model.Employees;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
     EmployeeService employeeService;

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getUser(@PathVariable("id") Long id) {
        EmployeeDto employeeDto =  employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee =  employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> listEmployee(){
        List<EmployeeDto> employeeDto = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("")
    public ResponseEntity<EmployeeDto> updateEmployees( @RequestBody EmployeeDto employeeDto){

        EmployeeDto employee = employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable Long id ){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted Successfully");
    }


}
