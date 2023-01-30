package com.example.myuniver.repository;

import com.example.myuniver.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Long>, JpaSpecificationExecutor<Teachers> {
}
