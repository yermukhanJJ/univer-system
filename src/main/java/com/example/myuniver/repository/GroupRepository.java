package com.example.myuniver.repository;

import com.example.myuniver.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long>, JpaSpecificationExecutor<Groups> {
    @Query("select g.id from Groups g where g.group_ = :name")
    Long findIdBygroup_(@Param("name") String name);
}
