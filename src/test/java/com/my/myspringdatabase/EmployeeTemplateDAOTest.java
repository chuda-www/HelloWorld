package com.my.myspringdatabase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beansfordatabase.xml")

public class EmployeeTemplateDAOTest {

    @Autowired
    private EmployeeAgeTemplateDAO employeeDAO;

    private static Employee createEmployeeObject(String name, Integer age) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        return employee;
    }

    @Test
    public void createTestExeption() {

        JdbcTestUtils.deleteFromTables(employeeDAO.jdbcTemplate, "Employee");

        try {
            Employee employee3 = createEmployeeObject("Anna", 11);
            Employee employee4 = createEmployeeObject("Anna", 22);
            employeeDAO.create(employee3);
            employeeDAO.create(employee4);
            Assert.fail("BAD INPUT");
        }
        catch (Exception e) {
            System.out.println("creation error");
        }
    }

    @Test
    public void createTest() {
        JdbcTestUtils.deleteFromTables(employeeDAO.jdbcTemplate, "Employee");

        //create
        Employee employee1 = createEmployeeObject("Zara", 11);
        Integer createIdEmployee = employeeDAO.create(employee1);
        System.out.println("Create record: " + employeeDAO.listEmployee());
        int c = JdbcTestUtils.countRowsInTable(employeeDAO.jdbcTemplate, "Employee");
        Assert.assertTrue(c == 1);

        // getById
        Employee resultGetById = employeeDAO.getById(createIdEmployee);
        Assert.assertNotNull(resultGetById);
        System.out.println(resultGetById);
        Assert.assertEquals("Zara", resultGetById.getName());

        //update
        int emp = employeeDAO.update(3, "Jane");
        int n = JdbcTestUtils.countRowsInTableWhere(employeeDAO.jdbcTemplate, "Employee", "name = 'Jane' ");
        Assert.assertTrue(n == 1);
        Assert.assertTrue(emp == 1);

        //listEmployee
        List <Employee> list = employeeDAO.listEmployee();
        System.out.println("All loaded list: " + list);
        Assert.assertTrue(list.size() == 1);

        //deleteById
        employeeDAO.deleteById(3);
        System.out.println("List: " + employeeDAO.listEmployee());
        c = JdbcTestUtils.countRowsInTable(employeeDAO.jdbcTemplate, "Employee");
        Assert.assertTrue(c == 0);
    }
}

