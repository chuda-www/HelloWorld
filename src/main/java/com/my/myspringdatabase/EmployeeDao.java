package com.my.myspringdatabase;

import javax.sql.DataSource;
import java.util.List;

interface EmployeeDao {

    void create(String name, Integer age);

    Employee getById(Integer id);

    void update(Integer id, Object object);

    void deleteById(Integer id);

    List <Employee> listEmployee();
}

