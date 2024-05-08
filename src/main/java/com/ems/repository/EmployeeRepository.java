package com.ems.repository;
import com.ems.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    Employees findByFirstName(String firstName);

    Optional<Employees> findByEmail(String email);

    @Override
    void deleteById(Long id);
}
