package com.my.myspringdatabase;

import javax.sql.DataSource;

public class EmployeeNameTemplateDAO extends EmployeeAgeTemplateDAO {

    public EmployeeNameTemplateDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void update(Integer id, Object object) {
        String SQL = "update Employee set name = ? where id = ?";
        jdbcTemplate.update(SQL, object, id);
        log.debug("Updated Record with ID = " + id + "\n");
    }
}
