package com.Sodith.GreenStitch.Service;

import com.Sodith.GreenStitch.Confiq.JwtUtil;
import com.Sodith.GreenStitch.Exception.EmployeeAlreadyExists;
import com.Sodith.GreenStitch.Exception.EmployeeNotFoundException;
import com.Sodith.GreenStitch.Modal.Employee;
import com.Sodith.GreenStitch.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployeeDetails(Employee employee) throws EmployeeAlreadyExists {
        try {
            logger.info("I am in save Employee. Received Employee: {}", employee);
            // Check if an employee with the same username already exists
            Employee existingEmployee = employeeRepository.findByUserName(employee.getUserName());
            if (existingEmployee != null) {
                throw new EmployeeAlreadyExists("Employee with User_Name " + employee.getUserName() + " already exists.");
            }
            // Encode the password before saving to the database
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            return employeeRepository.save(employee);
        } catch (Exception e) {
            logger.error("Error saving employee: {}", e.getMessage());
            throw e;
        }
    }

}
