package com.my.myspringdatabase;

import javax.sql.DataSource;
import java.util.List;

interface EmployeeDAO {

    void create(Employee employee);

    Employee getById(Integer id);

    void update(Integer id,Object object);

    void deleteById(Integer id);

    List <Employee> listEmployee();

}

