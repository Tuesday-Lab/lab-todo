package com.circlee.todo.dto;

import lombok.Data;

@Data
public class TodoDTO {

    private Long id;

    private String title;

    private Boolean isDone;
}
