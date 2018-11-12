package com.my.myspringdatabase;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeAgeTemplateDAO implements EmployeeDAO {

    public JdbcTemplate jdbcTemplate;

    public EmployeeAgeTemplateDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Employee employee) {
        String SQL = "INSERT INTO Employee (name, age) VALUES (?, ?)";
        jdbcTemplate.update(SQL, employee.getName(), employee.getAge());
        System.out.println("Created Record Name = " + employee.getName() + " Age = " + employee.getAge());
    }

    public Employee getById(Integer id) {
        String SQL = "select * from Employee where id = ?";
        Employee employees = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());
        return employees;
    }

    public List <Employee> listEmployee() {
        String SQL = "select * from Employee";
        List <Employee> employeeList = jdbcTemplate.query(SQL, new EmployeeMapper());
        return employeeList;
    }

    public void deleteById(Integer id) {
        String SQL = "delete from Employee where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
    }

    public void update(Integer id, Employee employee) {
        String SQL = "update Employee set age = ? where id = ?";
        jdbcTemplate.update(SQL, employee.getAge(), id);
        System.out.println("Updated Record with ID = " + employee.getId());
    }
}
