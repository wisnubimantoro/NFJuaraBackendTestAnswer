package com.exam.backendTest.NFJuara.controller;

import com.exam.backendTest.NFJuara.domain.Todos;
import com.exam.backendTest.NFJuara.service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodosController {

    private final TodosService todosService;

    @Autowired
    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @RequestMapping(path = "/app/todo", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public void addTodoData(@RequestBody Todos todos){

        try {
            todosService.addNewTodos(todos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/app/todo/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateTodoData(@PathVariable(value = "id") int id){

        try{
            todosService.updateSelectedTodos(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/app/todo/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity getSpesifiedTodoData(@PathVariable(value = "id") int id){

        try {
            todosService.getSelectedTodos(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e){
         e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/app/todo/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity deleteTodoData(@PathVariable(value = "id") int id){

        try {
            todosService.deleteSelectedTodos(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/app/todos", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity getAllTodoData(){
        try{
            todosService.getAllTodos();
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
