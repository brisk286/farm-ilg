package com.brisk.farm_serve.service;

import com.brisk.farm_serve.entity.Commit;
import com.brisk.farm_serve.entity.Device;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

public interface CommitInfoService {

    Commit getCommitById(Long commit_id);

    void insertCommit(Commit commit);

    void deleteCommit(Long commit_id);

    Commit getCommitInTime(Timestamp start_time, Timestamp end_time, Long device_id);
}
