package com.exam.backendTest.NFJuara.dao;

import com.exam.backendTest.NFJuara.domain.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TagsDAO extends JpaRepository<Tags, Long> {

    List<Tags> findById(int id);

    List<Tags> findByName(String name);
}
