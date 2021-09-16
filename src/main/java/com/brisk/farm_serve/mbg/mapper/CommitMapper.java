package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.Area;
import com.brisk.farm_serve.entity.Commit;
import com.brisk.farm_serve.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;

public interface CommitMapper {

    Commit getCommitById(@Param("commit_id") Long commit_id);

    Commit getCommitInTime(@PathVariable(value = "device_id") Long device_id, @PathVariable(value = "start_time") Timestamp start_time, @PathVariable(value = "start_time") Timestamp end_time);

    void insertCommit(@Param("commit") Commit commit);

    void deleteCommit(@Param("commit_id") Long commit_id);
}
