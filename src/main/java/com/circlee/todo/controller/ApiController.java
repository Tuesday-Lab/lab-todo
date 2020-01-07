package com.circlee.todo.controller;

import com.circlee.todo.config.advice.ExceptionAdvice;
import com.circlee.todo.dto.TodoDTO;
import com.circlee.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/todos")
public class ApiController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDTO> getTodos() {

//        return this.todoService.getTodos();
        throw new ExceptionAdvice.CustomException("done!!!");
    }

    @GetMapping(value = "{todoId}")
    public TodoDTO getTodo(@PathVariable("todoId") Long todoId) {
        return this.todoService.getTodo(todoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO saveTodo(@RequestBody @Valid TodoDTO todoDTO, HttpServletResponse response) {
        TodoDTO result = this.todoService.saveTodo(todoDTO);
        response.setHeader(HttpHeaders.LOCATION, "/todos/" + result.getId());
        return result;
    }

    @DeleteMapping(value = "{todoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        this.todoService.deleteTodo(todoId);
    }


}
