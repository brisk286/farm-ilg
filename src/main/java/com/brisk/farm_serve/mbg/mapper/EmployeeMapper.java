package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface EmployeeMapper {

    ArrayList<Employee> getEmployee();

    ArrayList<Employee> getEmployeeByName(@Param("employee_name") String employee_name);

    void updateEmployee(@Param("employee") Employee employee);

    void insertEmployee(@Param("employee") Employee employee);

    void deleteEmployee(@Param("employee_id") Long employee_id);

}
