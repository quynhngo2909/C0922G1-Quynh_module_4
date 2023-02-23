package com.casestudy.service;

import com.casestudy.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> employees();
    Employee findById(int id);
}
