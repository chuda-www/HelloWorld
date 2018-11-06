package com.my.myspringdatabase;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeTemplateDAO implements EmployeeDao {

    private JdbcTemplate jdbcTemplateObject;

    public EmployeeTemplateDAO(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, Integer age) {
        String SQL = "INSERT INTO Employee (name, age) VALUES (?, ?)";
        jdbcTemplateObject.update(SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
    }

    public Employee getById(Integer id) {
        String SQL = "select * from Employee where id = ?";
        Employee employee = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());
        return employee;
    }

    public List <Employee> listEmployee() {
        String SQL = "select * from Employee";
        List <Employee> employeeList = jdbcTemplateObject.query(SQL, new EmployeeMapper());
        return employeeList;
    }

    public void deleteById(Integer id) {
        String SQL = "delete from Employee where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
    }

    public void update(Integer id, Integer age) {
        String SQL = "update Employee set age = ? where id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id);
    }

    public void updateName(Integer id, String name) {
        String SQL = "update Employee set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with Name = " + name);

    }
}
