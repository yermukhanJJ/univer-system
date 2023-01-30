package com.example.myuniver.repository;

import com.example.myuniver.model.Groups;
import com.example.myuniver.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long>, JpaSpecificationExecutor<Students> {
    @Query("select s from Students s join Groups g on g.id = s.group_id where g.id = :id_group")
    List<Students> findByStudentsByGroup(@Param("id_group") Long id);
}
