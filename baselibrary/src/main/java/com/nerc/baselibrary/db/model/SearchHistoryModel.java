package com.nerc.baselibrary.db.model;

import com.nerc.baselibrary.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/**
 * 记录 搜索记录
 * Created by nerc on 2017/10/31.
 */

@Table(database = AppDatabase.class)
public class SearchHistoryModel extends BaseModel {

    @Column
    @PrimaryKey
    private String content;
    @Column
    private Date date;

    public SearchHistoryModel() {
    }

    public SearchHistoryModel(String content) {
        this.content = content;
        date = new Date();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
