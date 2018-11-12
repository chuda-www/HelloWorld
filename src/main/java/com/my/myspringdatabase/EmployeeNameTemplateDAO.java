package com.my.myspringdatabase;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class EmployeeNameTemplateDAO extends EmployeeAgeTemplateDAO {
    private JdbcTemplate jdbcTemplate;
    Employee employee = new Employee();

    public EmployeeNameTemplateDAO(DataSource dataSource) {
        super(dataSource);
    }
@Override
    public void update(Integer id, Object object) {
        String SQL = "update Employee where id = ? set name = ? ";
        jdbcTemplate.update(SQL, id, employee.getName());
        System.out.println("Updated Record with Name = " + employee.getName());
    }
}
