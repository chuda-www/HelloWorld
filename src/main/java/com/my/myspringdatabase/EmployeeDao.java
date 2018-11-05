package com.my.myspringdatabase;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDao {

    public void setDataSource(DataSource ds);

    public void create(String name, Integer age);

    public Employee getById(Integer id);

    public void update(Integer id, Integer age);

    public void deleteById(Integer id);

    public List <Employee> listEmployee();
}

