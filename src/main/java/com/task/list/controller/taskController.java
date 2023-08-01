package com.task.list.controller;

import com.task.list.DTOs.request.taskRequest;
import com.task.list.DTOs.response.taskResponse;
import com.task.list.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "task-api")
public class taskController {

    @Autowired
    taskService service;

    /*
    metodo para listar todas as tarefas
     */
    @GetMapping
    public ResponseEntity<List<taskResponse>> listAllTasks(){

        return ResponseEntity.status(HttpStatus.OK).body(service.listAllTasks());

    }

    /*
    metodo para salvar uma nova tarefa
     */
    @PostMapping
    public ResponseEntity<taskResponse> createNewTask(@RequestBody taskRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewTask(request));

    }

    /*
    metodo para editar uma tarefa
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<taskResponse> updateTask(@PathVariable(value = "id") Long cdTask, @RequestBody taskRequest request) {

        return ResponseEntity.status(HttpStatus.OK).body(service.updateTask(request, cdTask));

    }


}
