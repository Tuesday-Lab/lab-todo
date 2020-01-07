package com.circlee.todo.domain;

import com.circlee.todo.dto.TodoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@DynamicUpdate
@ToString
public class Todo {

    public Todo(){

    }

    private Todo(Long id, String title) {
        this.id = id;
        this.title = title;
        this.isDone = false;
    }

    public static Todo from(TodoDTO todoDto) {
        return new Todo(todoDto.getId(), todoDto.getTitle());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @NotBlank
    private String title;

    @NotNull
    private Boolean isDone;
}
