package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.po.Commit;

import java.sql.Timestamp;

public interface CommitInfoService {

    Commit getCommitById(Long commit_id);

    void insertCommit(Commit commit);

    void deleteCommit(Long commit_id);

    Commit getCommitInTime(Timestamp start_time, Timestamp end_time, Long device_id);
}
