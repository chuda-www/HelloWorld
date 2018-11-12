package com.my.myspringdatabase;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class EmployeeNameTemplateDAO extends EmployeeAgeTemplateDAO {

    public EmployeeNameTemplateDAO(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void update(Integer id, Object object) {
        String SQL = "update Employee set name = ? where id = ?";
        jdbcTemplate.update(SQL, object, id);
        System.out.println("Updated Record with ID = " + id);
    }
}
