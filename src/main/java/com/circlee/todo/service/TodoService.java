package com.circlee.todo.service;

import com.circlee.todo.domain.Todo;
import com.circlee.todo.dto.TodoDTO;
import com.circlee.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoDTO> getTodos() {
        return this.todoRepository.findAll().stream()
                .map(todo -> TodoDTO.from(todo))
                .collect(Collectors.toList());
    }

    public TodoDTO getTodo(Long todoId) {
        Optional<Todo> todoResult = this.todoRepository.findById(todoId);

        return todoResult.map(todo -> TodoDTO.from(todo))
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Transactional
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = Todo.from(todoDTO);
        this.todoRepository.save(todo);
        return TodoDTO.from(todo);
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        this.todoRepository.deleteById(todoId);
    }

}
