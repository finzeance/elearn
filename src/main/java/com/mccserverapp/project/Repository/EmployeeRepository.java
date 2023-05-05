package com.mccserverapp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mccserverapp.project.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
