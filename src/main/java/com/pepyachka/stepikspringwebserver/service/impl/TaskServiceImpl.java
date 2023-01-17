package com.pepyachka.stepikspringwebserver.service.impl;

import com.pepyachka.stepikspringwebserver.entity.Task;
import com.pepyachka.stepikspringwebserver.repository.TaskRepository;
import com.pepyachka.stepikspringwebserver.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks(Long accountId) {
        return taskRepository.findByAccountId(accountId);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void markAsDone(Long id) {
        taskRepository.markAsDone(id);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
