package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.entity.Commit;
import com.brisk.farm_serve.service.CommitInfoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CommitInfoServiceImpl implements CommitInfoService {
    @Override
    public Commit getCommitById(Long commit_id) {
        return null;
    }

    @Override
    public void insertCommit(Commit commit) {

    }

    @Override
    public void deleteCommit(Long commit_id) {

    }

    @Override
    public Commit getCommitInTime(Timestamp start_time, Timestamp end_time, Long device_id) {
        return null;
    }
}
