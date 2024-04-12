package com.ems.repository;

import com.ems.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    Employees findByFirstName(String firstName);

    @Override
    void deleteById(Long id);
}
