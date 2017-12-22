package com.nerc.baselibrary.db.model;

import com.nerc.baselibrary.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/**
 * 投票记录 避免一天中重复投票（重复投票后台接口中有逻辑过滤）
 * 用于本地判断是否能投票，根据是否能投票显示不同的 UI
 * Created by nerc on 2017/10/18.
 */

@Table(database = AppDatabase.class)
public class WorkVoteRecordModel extends BaseModel {

    @Column
    @PrimaryKey
    private String id;
    @Column
    private String competitionId;
    @Column
    private String workId;
    @Column
    private Date voteDate;

    public WorkVoteRecordModel() {

    }

    public WorkVoteRecordModel(String competitionId, String workId, Date voteDate) {
        this.competitionId = competitionId;
        this.workId = workId;
        this.voteDate = voteDate;
        this.id = competitionId + workId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(String competitionId, String workId) {
        this.id = competitionId + workId;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }
}
