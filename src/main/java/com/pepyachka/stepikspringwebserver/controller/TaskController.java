package com.pepyachka.stepikspringwebserver.controller;

import com.pepyachka.stepikspringwebserver.entity.Task;
import com.pepyachka.stepikspringwebserver.service.AccountService;
import com.pepyachka.stepikspringwebserver.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final AccountService accountService;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        task.setAccountId(accountService.getCurrentAccount().getId());
        return taskService.create(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks(accountService.getCurrentAccount().getId());
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        taskService.updateTask(task);
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id) {
        taskService.markAsDone(id);
    }
}

