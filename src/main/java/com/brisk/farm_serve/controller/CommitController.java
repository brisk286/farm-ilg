package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.pojo.po.Commit;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.CommitInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/commit")
@Api(tags = "提交记录: Commit")
public class CommitController {

    @Autowired
    private CommitInfoService commitInfoService;

    @GetMapping(value = "/{commit_id}")
    @ApiOperation(value = "查询提交记录")
    public CommonResult<Commit> getCommitById(@PathVariable(value = "commit_id") Long commit_id) {
        Commit commit = commitInfoService.getCommitById(commit_id);
        return CommonResult.success(commit);
    }

    @PostMapping
    @ApiOperation(value = "添加提交记录")
    public CommonResult<Object> insertCommit(@RequestBody Commit commit){
        commitInfoService.insertCommit(commit);
        return CommonResult.success();
    }

    @DeleteMapping(value = "/{commit_id}")
    @ApiOperation(value = "删除提交记录")
    public CommonResult<Object> deleteCommit(@PathVariable(value = "commit_id") Long commit_id){
        commitInfoService.deleteCommit(commit_id);
        return CommonResult.success();
    }

    @GetMapping(value = "/inTime/{device_id}/{start_time}/{end_time}")
    @ApiOperation(value = "查询设备在一段时间内提交的数据")
    public CommonResult<Commit> getCommitInTime(@PathVariable(value = "start_time") Timestamp start_time, @PathVariable(value = "start_time") Timestamp end_time, @PathVariable(value = "commit_id") Long commit_id) {
        Commit commit = commitInfoService.getCommitInTime(start_time, end_time, commit_id);
        return CommonResult.success(commit);
    }
}
