package com.task.list.repository;

import com.task.list.DTOs.response.taskResponse;
import com.task.list.entity.taskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface taskRepository extends JpaRepository<taskEntity, Long> {


    List<taskEntity> findAllByFinishFalse();

}
