package com.task.list.DTOs.request;

public class taskRequest {


    private Long cdId;

    private String name;

    private String description;

    private boolean finish;

    private int priority;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public taskRequest(Long cdId, String name, String description, boolean finish, int priority) {
        this.cdId = cdId;
        this.name = name;
        this.description = description;
        this.finish = finish;
        this.priority = priority;
    }
}
