package com.Sodith.GreenStitch.Controller;

import com.Sodith.GreenStitch.Confiq.JwtUtil;
import com.Sodith.GreenStitch.Exception.EmployeeAlreadyExists;
import com.Sodith.GreenStitch.Exception.EmployeeNotFoundException;
import com.Sodith.GreenStitch.Exception.ErrorDetails;
import com.Sodith.GreenStitch.Modal.Employee;
import com.Sodith.GreenStitch.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee) throws EmployeeAlreadyExists {
        Employee savedEmployee = employeeService.saveEmployeeDetails(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody Employee employee) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(employee.getUserName(), employee.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(employee.getUserName());
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from GreenStitch";
    }


}

