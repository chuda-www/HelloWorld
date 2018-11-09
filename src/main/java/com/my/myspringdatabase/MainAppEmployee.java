package com.my.myspringdatabase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainAppEmployee {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansfordatabase.xml");
        EmployeeDao employeeDAO = context.getBean(EmployeeDao.class);

        System.out.println("------Records Creation--------");
        employeeDAO.create("Zara", 11);
        employeeDAO.create("Nuha", 2);
        employeeDAO.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------");
        List <Employee> employeeList = employeeDAO.listEmployee();

        for (Employee record : employeeList) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----");
        employeeDAO.update(2, 20);

        System.out.println("----Updating Record with ID = 2 -----");
        employeeDAO.update(2, "Olga");

        System.out.println("----Listing Record with ID = 2 -----");
        Employee employee = employeeDAO.getById(2);
        System.out.print("ID : " + employee.getId());
        System.out.print(", Name : " + employee.getName());
        System.out.println(", Age : " + employee.getAge());

    }
}
