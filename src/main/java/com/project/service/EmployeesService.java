package com.project.service;

import com.project.bean.Employees;
import com.project.dao.EmployeesDAO;

public class EmployeesService {

    EmployeesDAO employeesDAO = new EmployeesDAO();

    public Employees emailVerify(Employees employee) {
        return employeesDAO.emailVerify(employee);
    }
}
