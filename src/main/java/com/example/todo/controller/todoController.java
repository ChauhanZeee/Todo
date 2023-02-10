package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.ITodoService;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-app")
public class todoController {

    //@RequestMapping("/status")
    //public String helloUser() {
    //  return "Hey baby";
    // }

//    @RequestMapping("/api")
//    //getmapping telling this class whenever browser hitting that url we should call below function;
//    public String helloUser(@RequestParam String username) {
//        return "Hey baby"+username;
//    }

    //https://github.com/ssc-stack/todo-app/tree/master/
    //@RequestMapping("/api/username/{username}/roll/{roll}/status/{status}")
//    public String helloUser(@PathVariable String username, @PathVariable String roll, @PathVariable String status) {
//        return "Hey baby"+ username +" " +roll+" "+ status;
//        //this is use in uri path for multiple param;
//    }

    //crud operation:---

    //@RequestMapping (value="", method=RequestMethod.GET)
    //instead of writhing these longer line we write below lines.
    @Autowired // it provide default constructer itself. used to inject dependency
    private ITodoService todoService;

    //todo service dependency inject in todo controller class.
//    public todoController(TodoService todoService){// dependency injection
//        this.todoService = todoService;
//    }
    //in order to not write constructor we use autowired annotation.
    @PostMapping("/add-todo")
    public void createTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }
    @GetMapping("find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id){
        return todoService.findById(id);
    }
    //http://localhost:8080/api/v1/todo-app/find-all
    @GetMapping("/find-all")
    public List<Todo> findAllTodo(){ // controller is talking to service layer;
        return todoService.findAll();
    }
    @PutMapping("/update-todo/id/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id, todo);
    }
    @DeleteMapping("/to-delete/id/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404 not found
        return new ResponseEntity<>(HttpStatus.OK);// 200 ok
    }
    //responce entity allows us to return data along with status code, like ok, not found, etc
    //basicalyy we can change the status code with our own.
}
