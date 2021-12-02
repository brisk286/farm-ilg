package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.mbg.mapper.EmployeeMapper;
import com.brisk.farm_serve.pojo.po.Employee;
import com.brisk.farm_serve.service.EmployeeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class EmployInfoServiceImpl implements EmployeeInfoService {

    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public ArrayList<Employee> getEmployee() {
        return employeeMapper.getEmployee();
    }

    @Override
    public ArrayList<Employee> getEmployeeByName(String employee_name) {
        return employeeMapper.getEmployeeByName(employee_name);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long employee_id) {
        employeeMapper.deleteEmployee(employee_id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }
}
