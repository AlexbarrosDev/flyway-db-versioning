package com.alexdev.enums;

public enum TaskStatus {

    TO_DO(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private final int code;

    private TaskStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskStatus valueOf(int code) {
        for (TaskStatus value : TaskStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("\"Invalid TaskStatus code: \" + code");
    }
}
