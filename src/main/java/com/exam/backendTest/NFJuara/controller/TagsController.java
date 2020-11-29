package com.exam.backendTest.NFJuara.controller;

import com.exam.backendTest.NFJuara.domain.Tags;
import com.exam.backendTest.NFJuara.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagsController {

    private final TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @RequestMapping(path = "/app/tag", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public void addTodoData(@RequestBody Tags tags){

        try {
            tagsService.addNewTags(tags);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/app/todo/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateTodoData(@PathVariable(value = "id") int id){

        try{
            tagsService.updateSelectedTags(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/app/todo/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity getSpesifiedTodoData(@PathVariable(value = "id") int id){

        try {
            tagsService.getSelectedTags(id);
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
            tagsService.deleteSelectedTags(id);
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
            tagsService.getAllTags();
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
