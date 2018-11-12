package com.my.myspringdatabase;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class EmployeeNameTemplateDAO extends EmployeeAgeTemplateDAO {
    private JdbcTemplate jdbcTemplate;

    public EmployeeNameTemplateDAO(DataSource dataSource) {
        super(dataSource);
    }

    public void update(Employee employee) {
        String SQL = "update Employee where id = ? set name = ? ";
        jdbcTemplate.update(SQL, employee.getId(),employee.getName());
        System.out.println("Updated Record with Name = " + employee.getName());
    }
}
