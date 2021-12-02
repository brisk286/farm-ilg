package com.brisk.farm_serve.service;


import com.brisk.farm_serve.mbg.mapper.EmployeeMapper;
import com.brisk.farm_serve.pojo.dto.NextDayPlan;
import com.brisk.farm_serve.pojo.po.Employee;
import com.brisk.farm_serve.pojo.po.Opt;

import java.util.ArrayList;

public interface EmployeeInfoService {

    ArrayList<Employee> getEmployee();

    ArrayList<Employee> getEmployeeByName(String employee_name);

    void insertEmployee(Employee employee);

    void deleteEmployee(Long employee_id);

    void updateEmployee(Employee employee);

}
