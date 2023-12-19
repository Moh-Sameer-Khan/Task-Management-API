package com.apiwiz.TaskManagement.repository;

import com.apiwiz.TaskManagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepo extends JpaRepository<Task, Integer> {

}
