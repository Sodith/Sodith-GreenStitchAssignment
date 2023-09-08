package com.Sodith.GreenStitch.Repository;

import com.Sodith.GreenStitch.Modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    Employee findByUserName(String username);
}
