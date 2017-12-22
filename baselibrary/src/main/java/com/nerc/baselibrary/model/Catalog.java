package com.nerc.baselibrary.model;

import java.util.List;

public class Catalog {
    public static final String RESOURCE_TYPE_VIDEO = "video";
    public static final String RESOURCE_TYPE_HOMEWORK = "homework";
    public static final String RESOURCE_TYPE_EXAM = "exam";
    public static final int RESOURCE_DOWNLOAD_NO = 0;
    public static final int RESOURCE_DOWNLOAD_DOWNLOADING = 1;
    public static final int RESOURCE_DOWNLOAD_FINISH = 2;

    private String catalogID;
    private String catalogName;
    private List<Resource> resourceList;

    public static class Resource {
        private String resourceID;
        private String resourceName;
        private String resourceType;
        private String resourceUrl;
        private String resourceChapterID;
        private String endTime;
        private int downloading = 0;

        private String testExamTime;
        private String testExamState;
        private int testIsExpired;
        private int testExamNum;
        public String homeWorkScore; // 作业 分数

        public String getTestExamTime() {
            return testExamTime;
        }

        public void setTestExamTime(String testExamTime) {
            this.testExamTime = testExamTime;
        }

        public String getTestExamState() {
            return testExamState;
        }

        public void setTestExamState(String testExamState) {
            this.testExamState = testExamState;
        }

        public int getTestIsExpired() {
            return testIsExpired;
        }

        public void setTestIsExpired(int testIsExpired) {
            this.testIsExpired = testIsExpired;
        }

        public int getTestExamNum() {
            return testExamNum;
        }

        public void setTestExamNum(int testExamNum) {
            this.testExamNum = testExamNum;
        }

        public int getDownloading() {
            return downloading;
        }

        public void setDownloading(int downloading) {
            this.downloading = downloading;
        }

        public String getResourceChapterID() {
            return resourceChapterID;
        }

        public void setResourceChapterID(String resourceChapterID) {
            this.resourceChapterID = resourceChapterID;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getResourceID() {
            return resourceID;
        }

        public void setResourceID(String resourceID) {
            this.resourceID = resourceID;
        }

        public String getResourceName() {
            return resourceName;
        }

        public void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }

        public String getResourceType() {
            return resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

    }

    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

}
