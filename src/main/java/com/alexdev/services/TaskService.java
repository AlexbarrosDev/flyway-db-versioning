package com.alexdev.services;

import com.alexdev.dtos.response.TaskDTO;
import com.alexdev.entities.Task;
import com.alexdev.mappers.TaskMapper;
import com.alexdev.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> findAll() {

        return repository.findAll()
                .stream().map(TaskMapper::entityToDTO).toList();
    }

    @Transactional(readOnly = true)
    public TaskDTO findById(Long id) {

        Task entity =  repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        return TaskMapper.entityToDTO(entity);
    }

    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalStateException("Task not found");
        }
        repository.deleteById(id);
    }

    @Transactional
    public TaskDTO create(Task task) {

        taskValidate(task);

        Task entity = new Task(
                Instant.now(),
                task.getTask(),
                task.getStatus()
        );

        return TaskMapper.entityToDTO(repository.save(entity));
    }

    @Transactional
    public Task update(Long id, Task task) {

        Task entity = repository.findById(task.getId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        taskValidate(task);
        entity.setTask(task.getTask());
        entity.setMoment(Instant.now());
        entity.setStatus(task.getStatus());
        return repository.save(entity);
    }

    public void taskValidate(Task task) {

        if (task.getTask() == null || task.getTask().isEmpty()) {
            throw new IllegalStateException("Error: attribute task is empty!");
        }

        if (task.getStatus() == null) {
            throw new IllegalStateException("Error: attribute status is null!");
        }
    }
}
