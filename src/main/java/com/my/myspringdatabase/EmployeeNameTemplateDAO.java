package com.my.myspringdatabase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;

public class EmployeeNameTemplateDAO extends EmployeeAgeTemplateDAO {

    final private static Logger log = LogManager.getLogger(EmployeeNameTemplateDAO.class);

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
