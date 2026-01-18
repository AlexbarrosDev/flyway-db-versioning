package com.alexdev.mappers;

import com.alexdev.dtos.response.TaskDTO;
import com.alexdev.entities.Task;
import com.alexdev.enums.TaskStatus;

public class TaskMapper {

    public static TaskDTO entityToDTO(Task task) {

        return new TaskDTO(
                task.getId(),
                task.getMoment(),
                task.getTask(),
                TaskStatus.valueOf(task.getStatus())
                );
    }
}
