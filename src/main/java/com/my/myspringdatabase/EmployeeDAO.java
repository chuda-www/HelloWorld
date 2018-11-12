package com.my.myspringdatabase;

import javax.sql.DataSource;
import java.util.List;

interface EmployeeDAO {

    void create(Employee employee);

    Employee getById(Integer id);

    void update(Employee employee);

    void deleteById(Integer id);

    List <Employee> listEmployee();

}

