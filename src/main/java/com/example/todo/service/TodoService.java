package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class TodoService implements ITodoService {
    @Autowired
    private ITodoRepository todoRepository;
    private static List<Todo> todos= new ArrayList<>(); // in memory database;
    @Override
    public List<Todo> findAll(){ // business logic;
       // return todos;
        return todoRepository.findAll();
    }
    @Override
    public Todo findById(int id){
//        Predicate<? super Todo>predicate = todo -> todo.getId() == id;
//        Todo todo = todos.stream().filter(predicate).findFirst().get();
//        return todo;
        return todoRepository.findById(id).get();
    }
    @Override
    public void addTodo(Todo todo){
        //todos.add(todo);
        todoRepository.save(todo);
    }
    @Override
    public void deleteTodo(int id){
//        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//        todos.removeIf(predicate);

        //todos.removeIf(todo -> todo.getId() == id);
        todoRepository.deleteById(id);
    }
    @Override
    public void updateTodo(int id, Todo newTodo){
        //find todo to be updated
        //update todo
        //Todo todo = findById(id);
        Todo todo = todoRepository.findById(id).get();

//        todo.setId(newTodo.getId());
//        todo.setTitle(newTodo.getTitle());
//        todo.setStatus(newTodo.isStatus());
        todoRepository.save(todo);
    }
}
