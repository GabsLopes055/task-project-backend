package com.task.list.service;

import com.task.list.DTOs.request.taskRequest;
import com.task.list.DTOs.response.taskResponse;
import com.task.list.entity.taskEntity;
import com.task.list.repository.taskRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class taskService {

    @Autowired
    taskRepository repository;


    /*
    * metedo para listar todas as tarefas
    * */
    public List<taskResponse> listAllTasks(){

       Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );

        List<taskEntity> tasks = repository.findAll(sort);

        List<taskResponse> taskList = new ArrayList<>();
        for (taskEntity list : tasks) {
            taskResponse response = taskResponse.taskDTO(list);
            taskList.add(response);
        }

        return taskList;

    }

    /*Metodo para retornar todas as tarefas ainda não concluidas*/
    public List<taskResponse> listTasksPending() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );

        List<taskEntity> tasks = repository.findAllByFinishFalse(sort);

        List<taskResponse> taskList = new ArrayList<>();
        for (taskEntity list : tasks) {
            taskResponse response = taskResponse.taskDTO(list);
            taskList.add(response);
        }

        return taskList;
    }

    /*Metodo para retornar todas as tarefas concluidas*/
    public List<taskResponse> listTasksFinish() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );

        List<taskEntity> tasks = repository.findAllByFinishTrue(sort);

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
        taskEntity.setFinish(false);
        taskEntity.setPriority(request.getPriority());

        repository.save(taskEntity);

        return taskResponse.taskDTO(taskEntity);

    }

    /*
    metodo para editar uma tarefa
     */
    public taskResponse updateTask(@NotNull taskRequest request, Long cdTask) {

        Optional<taskEntity> updateTask = Optional.of(repository.findById(cdTask).orElseThrow());

        taskEntity task = updateTask.get();

//        task.setCdId(request.getCdId());
        task.setName(task.getName());
        task.setDescription(task.getDescription());
        task.setFinish(request.isFinish());
        task.setPriority(task.getPriority());

        repository.save(task);

        return taskResponse.taskDTO(task);

    }

    /*
    metodo para excluir uma tarefa realizada
     */
    public boolean deleteTask(Long cdTask) {

        Optional<taskEntity> findTask = repository.findById(cdTask);

        if(findTask.isPresent()) {
            this.repository.deleteById(cdTask);
            return true;
        } else {
            return false;
        }

    }

}
