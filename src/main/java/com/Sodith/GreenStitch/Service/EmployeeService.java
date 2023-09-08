package com.Sodith.GreenStitch.Service;

import com.Sodith.GreenStitch.Exception.EmployeeAlreadyExists;
import com.Sodith.GreenStitch.Exception.EmployeeNotFoundException;
import com.Sodith.GreenStitch.Modal.Employee;

import javax.naming.AuthenticationException;

public interface EmployeeService {

Employee saveEmployeeDetails(Employee employee) throws EmployeeAlreadyExists;




}
