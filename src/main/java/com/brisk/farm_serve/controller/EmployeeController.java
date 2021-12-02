package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.pojo.po.Device;
import com.brisk.farm_serve.pojo.po.Employee;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.EmployeeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/employee")
@Api(tags = "人员: Employee")
public class EmployeeController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @GetMapping(value = "")
    @ApiOperation(value = "查询员工")
    public CommonResult<ArrayList<Employee>> getEmployee(){
        ArrayList<Employee> employees = employeeInfoService.getEmployee();
        return CommonResult.success(employees);
    }

    @GetMapping(value = "/{employee_name}")
    @ApiOperation(value = "根据姓名查询员工")
    public CommonResult<ArrayList<Employee>> getEmployeeByName(@PathVariable(value = "employee_name") String employee_name){
        ArrayList<Employee> employees = employeeInfoService.getEmployeeByName(employee_name);
        return CommonResult.success(employees);
    }

    @PostMapping
    @ApiOperation(value = "添加员工")
    public CommonResult<Object> insertEmployee(@RequestBody Employee employee){
        employeeInfoService.insertEmployee(employee);
        return CommonResult.success();
    }

    @DeleteMapping(value = "/{employee_id}")
    @ApiOperation(value = "删除员工")
    public CommonResult<Object> deleteEmployee(@PathVariable(value = "employee_id") Long employee_id){
        employeeInfoService.deleteEmployee(employee_id);
        return CommonResult.success();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改员工")
    public CommonResult<Object> updateDevice(@RequestBody Employee employee) {
        employeeInfoService.updateEmployee(employee);
        return CommonResult.success();
    }
}
