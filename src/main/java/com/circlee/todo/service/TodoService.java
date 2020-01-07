package com.circlee.todo.service;

import com.circlee.todo.domain.Todo;
import com.circlee.todo.dto.TodoDTO;
import com.circlee.todo.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setIsDone(todoDTO.getIsDone());
        this.todoRepository.save(todo);

        todoDTO.setId(todo.getId());
        todoDTO.setIsDone(todo.getIsDone());
        return todoDTO;
    }

    public TodoDTO getTodo(Long todoId) {
        Optional<Todo> todoResult = this.todoRepository.findById(todoId);

        return todoResult.map(todo -> {
            TodoDTO todoDto = new TodoDTO();
            BeanUtils.copyProperties(todo, todoDto);
            return todoDto;
        }).orElseThrow(() -> {
            return new RuntimeException("Not Found");
        });

    }

}
