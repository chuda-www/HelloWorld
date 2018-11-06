package com.my.myspringdatabase;

import javax.sql.DataSource;
import java.util.List;

interface EmployeeDao {

    void create(String name, Integer age);

    Employee getById(Integer id);

    void update(Integer id, Integer age);

    void updateName(Integer id, String name);

    void deleteById(Integer id);

    List <Employee> listEmployee();
}

