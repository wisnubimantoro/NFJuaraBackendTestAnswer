package com.exam.backendTest.NFJuara.response;

import java.util.Date;
import java.util.List;

public class TodosResponse {

    private String name;
    private boolean isFinished;
    private boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private List<TagsResponse> tagsResponseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<TagsResponse> getTagsResponseList() {
        return tagsResponseList;
    }

    public void setTagsResponseList(List<TagsResponse> tagsResponseList) {
        this.tagsResponseList = tagsResponseList;
    }
}
