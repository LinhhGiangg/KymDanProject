package com.kymdan.backend.repository;

import com.kymdan.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFullName(String name);

    Employee findByEmail(String email);
}
