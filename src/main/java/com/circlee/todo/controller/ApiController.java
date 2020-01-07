package com.circlee.todo.controller;

import com.circlee.todo.dto.TodoDTO;
import com.circlee.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/todos")
public class ApiController {

    private final TodoService todoService;

    @GetMapping(value = "{todoId}")
    public TodoDTO getTodo(@PathVariable("todoId") Long todoId) {
        return this.todoService.getTodo(todoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO saveTodo(@RequestBody TodoDTO todoDTO, HttpServletResponse response) {
        TodoDTO result = this.todoService.saveTodo(todoDTO);
        response.setHeader(HttpHeaders.LOCATION, "/todos/" + result.getId());
        return result;
    }

}
