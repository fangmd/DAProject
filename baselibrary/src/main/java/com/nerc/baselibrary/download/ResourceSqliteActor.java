package com.nerc.baselibrary.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import org.jetbrains.annotations.NotNull;

import zlc.season.rxdownload3.core.Mission;
import zlc.season.rxdownload3.core.RealMission;
import zlc.season.rxdownload3.database.SQLiteActor;

/**
 * Created by nerc on 2017/10/24.
 */

public class ResourceSqliteActor extends SQLiteActor {

    private String RES_ID = "res_id";
    private String COURSE_ID = "course_id";

    public ResourceSqliteActor(@NotNull Context context) {
        super(context);
    }

    @NotNull
    @Override
    public String provideCreateSql() {
        String formatStr =
                "CREATE TABLE %s (\n" +
                        "%s TEXT PRIMARY KEY NOT NULL,\n" +
                        "%s TEXT NOT NULL,\n" +
                        "%s TEXT,\n" +
                        "%s TEXT,\n" +
                        "%s INTEGER,\n" +
                        "%s TEXT,\n" +
                        "%s TEXT, \n" +
                        "%s TEXT)";
        return String.format(formatStr, getTABLE_NAME(), getTAG(), getURL(),
                getSAVE_NAME(), getSAVE_PATH(), getRANGE_FLAG(), getTOTAL_SIZE(), RES_ID, COURSE_ID);
    }

    @NotNull
    @Override
    public ContentValues onCreate(@NotNull RealMission mission) {
        ContentValues cv = super.onCreate(mission);
        if (mission.getActual() instanceof ResourceMission) {
            ResourceMission customMission = (ResourceMission) mission.getActual();
            cv.put(RES_ID, customMission.getResId());
            cv.put(COURSE_ID, customMission.getCourseId());
        }
        return cv;
    }

    @NotNull
    @Override
    public Mission onGetAllMission(@NotNull Cursor cursor) {
        Mission mission = super.onGetAllMission(cursor);
        String resId = cursor.getString(cursor.getColumnIndexOrThrow(RES_ID));
        String courseId = cursor.getString(cursor.getColumnIndexOrThrow(COURSE_ID));
        if (resId == null || resId.isEmpty()) {
            resId = "no resId";
        }
        return new ResourceMission(mission, resId, courseId);
    }
}