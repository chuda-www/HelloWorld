package com.my.myspringdatabase;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class EmployeeNameTemplateDAO extends EmployeeTemplateDAO {
    private JdbcTemplate jdbcTemplateObject;

    public EmployeeNameTemplateDAO(DataSource dataSource) {
        super(dataSource);
    }

    public void update(Integer id, String name) {
        String SQL = "update Employee set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, id, name);
        System.out.println("Updated Record with Name = " + name);
    }
}
