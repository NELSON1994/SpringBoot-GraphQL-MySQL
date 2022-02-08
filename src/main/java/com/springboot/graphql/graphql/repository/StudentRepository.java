package com.springboot.graphql.graphql.repository;

import com.springboot.graphql.graphql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
