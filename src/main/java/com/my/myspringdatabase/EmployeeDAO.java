package com.my.myspringdatabase;

import java.util.List;

interface EmployeeDAO {

    void create(Employee employee);

    Employee getById(Integer id);

    Object update(Integer id, Object object);

    void deleteById(Integer id);

    List <Employee> listEmployee();

}

