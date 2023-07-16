package com.task.list.service;

import com.task.list.DTOs.request.taskRequest;
import com.task.list.DTOs.response.taskResponse;
import com.task.list.entity.taskEntity;
import com.task.list.repository.taskRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class taskService {

    @Autowired
    taskRepository repository;


    /*
    * metedo para listar todas as tarefas
    * */
    public List<taskResponse> listAllTasks(){

        List<taskEntity> tasks = repository.findAll();

        List<taskResponse> taskList = new ArrayList<>();
        for (taskEntity list : tasks) {
            taskResponse response = taskResponse.taskDTO(list);
            taskList.add(response);
        }

        return taskList;

    }

    /*
    /metodo para criar uma nova tarefa
     */
    public taskResponse createNewTask(@NotNull taskRequest request){

        taskEntity taskEntity = new taskEntity();

        taskEntity.setCdId(request.getCdId());
        taskEntity.setName(request.getName());
        taskEntity.setDescription(request.getDescription());
        taskEntity.setFinish(request.isFinish());
        taskEntity.setPriority(request.getPriority());

        repository.save(taskEntity);

        return taskResponse.taskDTO(taskEntity);

    }

}
