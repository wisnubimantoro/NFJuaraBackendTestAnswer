package com.exam.backendTest.NFJuara.service;

import com.exam.backendTest.NFJuara.dao.TagsDAO;
import com.exam.backendTest.NFJuara.domain.Tags;
import com.exam.backendTest.NFJuara.dto.TagsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TagsService {

    private final TagsDAO tagsDAO;

    @Autowired
    public TagsService(TagsDAO tagsDAO) {
        this.tagsDAO = tagsDAO;
    }

    public void addNewTags(Tags tags) throws Exception{

        TagsDTO tagsDTO = new TagsDTO();
        try {
            if (tagsDTO != null) {

                tags.setName(tagsDTO.getName());
                tags.setActive(true);
                tags.setCreatedAt(Date.from(Instant.now()));
                tags.setUpdatedAt(Date.from(Instant.now()));
            }
            tagsDAO.save(tags);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSelectedTags(int id){

        TagsDTO tagsDTO = new TagsDTO();

        List<Tags> tagsList = tagsDAO.findById(id);
        Tags tags = tagsList.get(id);

        tags.setName(tagsDTO.getName());

        tagsDAO.save(tags);
    }

    public void deleteSelectedTags(int id){

        List<Tags> tagsList = tagsDAO.findById(id);
        Tags tags = tagsList.get(id);
        tags.setActive(false);

        tagsDAO.save(tags);
    }

    public Tags getSelectedTags(int id){

        List<Tags> tagsList = tagsDAO.findById(id);
        Tags tags = tagsList.get(id);

        return tags;
    }

    public List<Tags> getAllTags(){

        List<Tags> tagsList = tagsDAO.findAll();
        return tagsList;
    }
}
