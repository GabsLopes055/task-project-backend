package com.task.list.repository;

import com.task.list.entity.taskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<taskEntity, Long> {
}
