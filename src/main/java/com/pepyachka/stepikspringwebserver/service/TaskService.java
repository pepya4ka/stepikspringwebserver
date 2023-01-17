package com.pepyachka.stepikspringwebserver.service;

import com.pepyachka.stepikspringwebserver.entity.Account;
import com.pepyachka.stepikspringwebserver.entity.Task;
import org.springframework.web.bind.annotation.*;

public interface TaskService {
    Task create(Task task);
    Iterable<Task> getAllTasks(Long accountId);
    Task getTaskById(Long id);
    void deleteTask(Long id);
    void markAsDone(Long id);

    Task updateTask(Task task);
}