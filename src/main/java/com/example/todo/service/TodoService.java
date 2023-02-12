package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService implements ITodoService {
    private static List<Todo> todos= new ArrayList<>(); // in memory database;
    private static int todoCount = 0;
//    static {
//        todos.add(new Todo(++todoCount, "learn spring boot", false));
//        todos.add(new Todo(++todoCount, "monday", false));
//        todos.add(new Todo(++todoCount, "tuesday", false));
//        todos.add(new Todo(++todoCount, "wednesday", false));
//        todos.add(new Todo(++todoCount, "thursday", false));
//    }
    @Override
    public List<Todo> findAll(){ // business logic;
        return todos;
    }
    @Override
    public Todo findById(int id){
        Predicate<? super Todo>predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    @Override
    public void addTodo(Todo todo){
        todos.add(todo);
    }
    @Override
    public void deleteTodo(int id){
//        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//        todos.removeIf(predicate);
        todos.removeIf(todo -> todo.getId() == id);
    }
    @Override
    public void updateTodo(int id, Todo newTodo){
        //find todo to be updated
        //update todo
        Todo todo = findById(id);

        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.isStatus());
    }
}
