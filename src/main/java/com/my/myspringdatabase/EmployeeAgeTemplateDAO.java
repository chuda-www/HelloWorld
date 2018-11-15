package com.my.myspringdatabase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeAgeTemplateDAO implements EmployeeDAO {

    protected JdbcTemplate jdbcTemplate;
    final private static Logger log = LogManager.getLogger(EmployeeAgeTemplateDAO.class);

    public EmployeeAgeTemplateDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Employee employee) {
        String SQL = "INSERT INTO Employee (name, age) VALUES (?, ?)";
        jdbcTemplate.update(SQL, employee.getName(), employee.getAge());
        log.debug("Created Record Name = " + employee.toString());
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
        log.debug("Deleted Record with ID = " + id);
    }

    public int update(Integer id, Object object) {
        String SQL = "update Employee  set age = ? where id = ?";
        int emp = jdbcTemplate.update(SQL, object, id);
        log.debug("Updated Record with ID = " + id);
        return emp;
    }
}
