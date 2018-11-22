package com.my.myspringdatabase;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreateEmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public void createEmployees(List <Employee> employeeList) {
        for (Employee employee : employeeList) {
            employeeDAO.create(employee);
        }
    }
}
