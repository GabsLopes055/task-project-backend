package com.task.list.DTOs.response;


import com.task.list.entity.taskEntity;

public class taskResponse {

    private Long cdId;

    private String name;

    private String description;

    private boolean finish;

    private int priority;

    public taskResponse() {
    }


    public static taskResponse taskDTO(taskEntity entity){

        taskResponse response = new taskResponse();

        response.setCdId(entity.getCdId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setFinish(entity.isFinish());
        response.setPriority(entity.getPriority());

        return response;
//        return new taskResponse(entity.getCdId(), entity.getName(), entity.getDescription(),entity.isFinish(), entity.getPriority());
    }


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
}
