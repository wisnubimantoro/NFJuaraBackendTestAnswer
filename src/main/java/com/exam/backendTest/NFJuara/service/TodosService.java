package com.exam.backendTest.NFJuara.service;

import com.exam.backendTest.NFJuara.dao.TagsDAO;
import com.exam.backendTest.NFJuara.dao.TodosDAO;
import com.exam.backendTest.NFJuara.domain.Tags;
import com.exam.backendTest.NFJuara.domain.Todos;
import com.exam.backendTest.NFJuara.dto.TodosDTO;
import com.exam.backendTest.NFJuara.response.TagsResponse;
import com.exam.backendTest.NFJuara.response.TodosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TodosService{

    private final TodosDAO todosDAO;
    private final TagsDAO tagsDAO;

    @Autowired
    public TodosService(TodosDAO todosDAO, TagsDAO tagsDAO) {
        this.todosDAO = todosDAO;
        this.tagsDAO = tagsDAO;
    }

    public void addNewTodos(Todos todos) throws Exception{

        TodosDTO todosDTO = new TodosDTO();
        try {
            if (todosDTO != null) {

                todos.setName(todosDTO.getName());
                todos.setActive(true);
                todos.setFinished(false);
                todos.setCreatedAt(Date.from(Instant.now()));
                todos.setUpdatedAt(Date.from(Instant.now()));
            }
            todosDAO.save(todos);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSelectedTodos(int id){

        TodosDTO todosDTO = new TodosDTO();

        List<Todos> todosList = todosDAO.findById(id);
        Todos todos = todosList.get(id);

        todos.setName(todosDTO.getName());

        todosDAO.save(todos);
    }

    public void deleteSelectedTodos(int id){

        List<Todos> todosList = todosDAO.findById(id);
        Todos todos = todosList.get(id);
        todos.setActive(false);

        todosDAO.save(todos);
    }

    public TodosResponse getSelectedTodos(int id){

        TodosResponse todosResponse = new TodosResponse();
        TagsResponse tagsResponse = new TagsResponse();

        List<Todos> todosList = todosDAO.findById(id);
        Todos todos = todosList.get(id);

        String name = todos.getName();

        List<Tags> tagsList = tagsDAO.findByName(name);

        List<TagsResponse> tagsResponses = new ArrayList<>();

        tagsResponse.setName(tagsList.get(id).getName());
        tagsResponse.setActive(tagsList.get(id).isActive());
        tagsResponse.setCreatedAt(tagsList.get(id).getCreatedAt());
        tagsResponse.setUpdatedAt(tagsList.get(id).getUpdatedAt());

        tagsResponses.add(tagsResponse);

        todosResponse.setName(todos.getName());
        todosResponse.setActive(todos.isActive());
        todosResponse.setFinished(todos.isFinished());
        todosResponse.setCreatedAt(todos.getCreatedAt());
        todosResponse.setUpdatedAt(todos.getUpdatedAt());
        todosResponse.setTagsResponseList(tagsResponses);

        return todosResponse;
    }

    public List<Todos> getAllTodos(){

        List<Todos> todosList = todosDAO.findAll();
        return todosList;
    }
}
