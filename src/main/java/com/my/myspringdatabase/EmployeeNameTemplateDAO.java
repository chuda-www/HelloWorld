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
    public int update(Integer id, Object object) {
        String SQL = "update Employee set name = ? where id = ?";
        int emp = jdbcTemplate.update(SQL, object, id);
        if (emp > 0) {
            log.debug("Updated Record with ID = " + id + " Value = " + object);
        } else {
            log.debug("Record not updated");
        }
        return emp;
    }
}