package com.exam.backendTest.NFJuara.dao;

import com.exam.backendTest.NFJuara.domain.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TodosDAO extends JpaRepository<Todos, Long> {

    List<Todos> findById(int id);
}
