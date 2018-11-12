package com.my.myspringdatabase;

import java.util.List;

interface EmployeeDAO {

    void create(Employee employee);

    Employee getById(Integer id);

    void update(Integer id, Employee employee);

    void deleteById(Integer id);

    List <Employee> listEmployee();

}

