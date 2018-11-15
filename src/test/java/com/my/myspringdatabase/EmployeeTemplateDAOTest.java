package com.my.myspringdatabase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    public void createTest() {

        //create
        Employee employee1 = createEmployeeObject("Zara", 11);
        employeeDAO.create(employee1);
        System.out.println("All loaded: " + employee1);

        // getById
        Employee resultGetById = employeeDAO.getById(1);
        Assert.assertNotNull(resultGetById);
        Assert.assertTrue("Zara".equals(resultGetById.getName()));

        int c = JdbcTestUtils.countRowsInTable(employeeDAO.jdbcTemplate, "Employee");
        Assert.assertTrue(c == 1);

        //update
        employeeDAO.update(1, "Jane");
        int n = JdbcTestUtils.countRowsInTableWhere(employeeDAO.jdbcTemplate, "Employee", "name = 'Jane' ");
        Assert.assertTrue(true);
        Assert.assertTrue(n == 1);

        //listEmployee
        List <Employee> list = employeeDAO.listEmployee();
        System.out.println("All loaded: " + list);
        Assert.assertTrue(list.size() == 1);

        //deleteById
        employeeDAO.deleteById(1);
        Assert.assertTrue(true);
        System.out.println("List: " + employee1);

        c = JdbcTestUtils.countRowsInTable(employeeDAO.jdbcTemplate, "Employee");
        Assert.assertTrue(c == 0);
    }
}

