package com.alexdev.dtos.response;

import com.alexdev.enums.TaskStatus;

import java.time.Instant;

public record TaskDTO(Long id, Instant moment, String task, TaskStatus status) {
}
